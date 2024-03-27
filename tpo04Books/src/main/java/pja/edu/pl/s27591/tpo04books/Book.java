package pja.edu.pl.s27591.tpo04books;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors;

    @ManyToOne
    private Publisher publisher;


    public Book(String name, List<Author> authors, Publisher publisher) {
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", title: " + name;
    }
}
