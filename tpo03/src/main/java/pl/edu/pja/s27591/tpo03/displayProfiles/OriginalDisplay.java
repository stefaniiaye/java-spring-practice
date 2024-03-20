package pl.edu.pja.s27591.tpo03.displayProfiles;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo03.DisplayInterface;
import pl.edu.pja.s27591.tpo03.Entry;

import java.util.List;

@Service
@Primary
@Profile("original")
public class OriginalDisplay implements DisplayInterface {
    @Override
    public void displayDict(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println("(Eng) " + entry.getEng() + "\t" + "(De) " + entry.getDe() + "\t" + "(Pl) " + entry.getPl());
        }
    }
}
