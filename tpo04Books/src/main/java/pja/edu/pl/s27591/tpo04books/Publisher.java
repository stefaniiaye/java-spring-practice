package pja.edu.pl.s27591.tpo04books;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER)
    private List<Book> books;

    public Publisher(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Publisher() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Publisher: " + name;
    }
}
