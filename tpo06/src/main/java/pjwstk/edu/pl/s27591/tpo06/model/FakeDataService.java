package pjwstk.edu.pl.s27591.tpo06.model;

import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class FakeDataService {
    public List<Person> generateFakeData(int quantity, Locale language, boolean includeAddress, boolean includeUniversity, boolean includeCountry, boolean includeCustomFields) {
        Faker faker = new Faker(language);
        List<Person> fakeData = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < quantity; i++) {
            Person person = new Person();
            person.setName(faker.name().firstName());
            person.setSurname(faker.name().lastName());
            person.setBirthDate(faker.date().birthday().toLocalDateTime().toLocalDate());
            fakeData.add(person);
        }
        return fakeData;
    }
}
