package pl.edu.pja.s27591.tpo03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class FlashcardsApp {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(FlashcardsApp.class);
        FlashcardsController controller = context.getBean(FlashcardsController.class);
        controller.runMenu();
    }
}
