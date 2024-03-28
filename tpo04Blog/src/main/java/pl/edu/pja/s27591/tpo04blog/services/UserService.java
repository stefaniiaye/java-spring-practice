package pl.edu.pja.s27591.tpo04blog.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo04blog.entities.User;
import pl.edu.pja.s27591.tpo04blog.repositories.ArticleRepository;
import pl.edu.pja.s27591.tpo04blog.repositories.BlogRepository;
import pl.edu.pja.s27591.tpo04blog.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("There is no such user in our database;("));
        user.getRoles().clear();
        articleRepository.nullifyArticleAuthorIds(userId);
        blogRepository.nullifyBlogManagerIds(userId);

        userRepository.deleteById(userId);
    }

    public void viewUsers() {
        for(User u : userRepository.findAll()){
            System.out.println(u);
        }
    }

}
