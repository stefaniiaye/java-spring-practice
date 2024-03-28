package pl.edu.pja.s27591.tpo04blog.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo04blog.repositories.ArticleRepository;
import pl.edu.pja.s27591.tpo04blog.entities.Article;
import pl.edu.pja.s27591.tpo04blog.repositories.BlogRepository;
import pl.edu.pja.s27591.tpo04blog.repositories.UserRepository;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    @Transactional
    public void deleteArticle(Long articleId) {
        if (articleRepository.existsById(articleId)) {
            articleRepository.deleteById(articleId);
        } else {
            throw new EntityNotFoundException("There is no such article is our database;(");
        }
    }

    public void viewArticles() {
        for(Article a : articleRepository.findAll()){
            System.out.println(a);
        }
    }
}
