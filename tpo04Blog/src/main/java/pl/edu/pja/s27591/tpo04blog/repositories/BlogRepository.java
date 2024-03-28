package pl.edu.pja.s27591.tpo04blog.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pja.s27591.tpo04blog.entities.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Blog B SET B.MANAGER_ID = NULL WHERE B.MANAGER_ID = :id", nativeQuery = true)
    void nullifyBlogManagerIds(@Param("id") Long userId);

}
