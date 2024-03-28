package pl.edu.pja.s27591.tpo04blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.edu.pja.s27591.tpo04blog.entities.Article;
import pl.edu.pja.s27591.tpo04blog.entities.Blog;
import pl.edu.pja.s27591.tpo04blog.entities.Role;
import pl.edu.pja.s27591.tpo04blog.entities.User;
import pl.edu.pja.s27591.tpo04blog.services.ArticleService;
import pl.edu.pja.s27591.tpo04blog.services.BlogService;
import pl.edu.pja.s27591.tpo04blog.services.RoleService;
import pl.edu.pja.s27591.tpo04blog.services.UserService;

@SpringBootApplication
public class Tpo04BlogApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Tpo04BlogApplication.class, args);


        UserService userService = context.getBean(UserService.class);
        User user1 = new User("user@gmail.com");
        User user2 = new User("lol@pjatk.com");
        userService.addUser(user1);
        userService.addUser(user2);

        userService.viewUsers();
        //userService.deleteUser(31L);
        //userService.viewUsers();

        BlogService blogService = context.getBean(BlogService.class);
        Blog blog1 = new Blog("blog228",user1);
        Blog blog2 = new Blog("blogmama",user2);
        blogService.addBlog(blog1);
        blogService.addBlog(blog2);

        blogService.viewBlogs();
        blogService.deleteBlog(21L);
        blogService.viewBlogs();

        RoleService roleService = context.getBean(RoleService.class);
        Role role1 = new Role("Cat");
        Role role2 = new Role("Dog");
        roleService.addRole(role1);
        roleService.addRole(role2);


        roleService.viewRoles();
        roleService.deleteRole(21L);
        roleService.viewRoles();


        ArticleService articleService = context.getBean(ArticleService.class);
        Article article = new Article("Why women kill", user2, blog2);
        articleService.addArticle(article);


        articleService.viewArticles();
        articleService.deleteArticle(21L);
        articleService.viewArticles();

    }

}
