package pl.edu.pja.s27591.tpo04blog.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "blog", fetch = FetchType.EAGER)
    private Set<Article> articles;
    @OneToOne
    @JoinColumn(name = "manager_id", unique = true)
    private User manager;

    public Blog(String name, User manager) {
        this.name = name;
        this.articles = new HashSet<>();
        this.manager = manager;
    }

    public Blog() {

    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public User getManager() {
        return manager;
    }
}
