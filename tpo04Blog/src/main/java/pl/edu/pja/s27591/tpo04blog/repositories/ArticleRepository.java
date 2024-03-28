package pl.edu.pja.s27591.tpo04blog.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.s27591.tpo04blog.entities.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
