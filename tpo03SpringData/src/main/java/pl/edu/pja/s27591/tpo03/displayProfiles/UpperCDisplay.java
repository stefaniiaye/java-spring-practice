package pl.edu.pja.s27591.tpo03.displayProfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo03.DisplayInterface;
import pl.edu.pja.s27591.tpo03.Entry;

import java.util.List;

@Service
@Profile("uppercase")
public class UpperCDisplay implements DisplayInterface {
    @Override
    public void displayDict(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println("(ENG) " + entry.getEng().toUpperCase() + "\t" + "(DE) " + entry.getDe().toUpperCase()
                    + "\t" + "(PL) " + entry.getPl().toUpperCase());
        }
    }

    @Override
    public String displayWord(String word) {
        return word.toUpperCase();
    }
}
