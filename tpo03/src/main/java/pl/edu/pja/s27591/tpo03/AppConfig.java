package pl.edu.pja.s27591.tpo03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfig {
    @Bean
    public FileService fileService(@Value("${pl.edu.pja.tpo02.filename}") String filename) {
        return new FileService(filename, entryRepository());
    }
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public EntryRepository entryRepository() {
        return new EntryRepository();
    }

}
