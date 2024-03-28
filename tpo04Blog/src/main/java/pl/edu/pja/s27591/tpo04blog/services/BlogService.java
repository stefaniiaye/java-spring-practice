package pl.edu.pja.s27591.tpo04blog.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo04blog.entities.Blog;
import pl.edu.pja.s27591.tpo04blog.repositories.BlogRepository;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Transactional
    public void deleteBlog(Long blogId) {
        if (blogRepository.existsById(blogId)) {
            blogRepository.deleteById(blogId);
        } else {
            throw new EntityNotFoundException("There is no such blog is our database;(");
        }
    }

    public void viewBlogs() {
        for(Blog b : blogRepository.findAll()){
            System.out.println(b);
        }
    }

}

