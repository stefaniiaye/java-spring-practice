package pl.edu.pja.s27591.tpo04blog.entities;

import jakarta.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private User author;
    @ManyToOne
    private Blog blog;

    public Article(String title, User author, Blog blog) {
        this.title = title;
        this.author = author;
        this.blog = blog;
    }

    public Article() {

    }

    @Override
    public String toString() {
        return "Article: " + title + ", ID: " + id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public Blog getBlog() {
        return blog;
    }
}
