package pl.edu.pja.s27591.tpo04blog.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "my_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Article> articles;
    @OneToOne(mappedBy = "manager")
    private Blog managedBlog;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(String email) {
        this.email = email;
        this.articles = new HashSet<>();
        this.roles = new HashSet<>();
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public Blog getManagedBlog() {
        return managedBlog;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
