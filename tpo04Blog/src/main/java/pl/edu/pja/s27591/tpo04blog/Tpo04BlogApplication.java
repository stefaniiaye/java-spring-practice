package pl.edu.pja.s27591.tpo04blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.pja.s27591.tpo04blog.entities.Blog;
import pl.edu.pja.s27591.tpo04blog.entities.User;
import pl.edu.pja.s27591.tpo04blog.services.BlogService;
import pl.edu.pja.s27591.tpo04blog.services.UserService;

@SpringBootApplication
public class Tpo04BlogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Tpo04BlogApplication.class, args);

        UserService userService = context.getBean(UserService.class);
        User user = new User("user@gmail.com");
        userService.addUser(user);

        userService.viewUsers();
        //userService.deleteUser(31L);
        //userService.viewUsers();

        BlogService blogService = context.getBean(BlogService.class);
        Blog blog = new Blog("blog228",user);
        blogService.addBlog(blog);

        blogService.viewBlogs();
        blogService.deleteBlog(21L);
        blogService.viewBlogs();
    }

}
