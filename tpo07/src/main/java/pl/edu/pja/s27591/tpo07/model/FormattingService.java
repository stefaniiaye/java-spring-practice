package pl.edu.pja.s27591.tpo07.model;

import com.google.googlejavaformat.java.Formatter;
import org.springframework.stereotype.Service;

@Service
public class FormattingService implements FormattingServiceInterface {
    @Override
    public String formatSourceCode(String initialCode) {
        try {
            return new Formatter().formatSource(initialCode);
        } catch (Exception e) {
            return "Oops, an error occurred during formatting your code. Please, try again.";
        }
    }
}
