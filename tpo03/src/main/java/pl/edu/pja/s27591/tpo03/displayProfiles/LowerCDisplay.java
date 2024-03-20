package pl.edu.pja.s27591.tpo03.displayProfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.edu.pja.s27591.tpo03.DisplayInterface;
import pl.edu.pja.s27591.tpo03.Entry;

import java.util.List;

@Service
@Profile("lowercase")
public class LowerCDisplay implements DisplayInterface{
    @Override
    public void displayDict(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println("(eng) " + entry.getEng().toLowerCase() + "\t" + "(de) " + entry.getDe().toLowerCase() +
                    "\t" + "(pl) " + entry.getPl().toLowerCase());
        }
    }
}
