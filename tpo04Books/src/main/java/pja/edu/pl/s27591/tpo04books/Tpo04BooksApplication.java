package pja.edu.pl.s27591.tpo04books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Tpo04BooksApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Tpo04BooksApplication.class, args);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        for (Book b : bookRepository.findAll())
            System.out.println(b);

    }

}
