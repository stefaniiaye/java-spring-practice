package pl.edu.pja.s27591.tpo04blog.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pja.s27591.tpo04blog.entities.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}
