package pl.edu.pja.s27591.tpo04blog.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo04blog.entities.User;
import pl.edu.pja.s27591.tpo04blog.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new EntityNotFoundException("There is no such user is our database;(");
        }
    }

    public void viewUsers() {
        for(User u : userRepository.findAll()){
            System.out.println(u);
        }
    }

}
