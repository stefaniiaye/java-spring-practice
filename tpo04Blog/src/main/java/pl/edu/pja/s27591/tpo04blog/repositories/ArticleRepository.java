package pl.edu.pja.s27591.tpo04blog.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pja.s27591.tpo04blog.entities.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Transactional
    void deleteArticlesByBlogId(Long blogId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Article A SET A.AUTHOR_ID = NULL WHERE A.AUTHOR_ID = :id", nativeQuery = true)
    void nullifyArticleAuthorIds(@Param("id") Long userId);

}
