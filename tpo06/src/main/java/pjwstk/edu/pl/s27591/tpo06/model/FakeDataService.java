package pjwstk.edu.pl.s27591.tpo06.model;

import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FakeDataService {
    public FakeDataDTO generateFakeData(int num, Locale locale, boolean address, boolean university, boolean country,
                                        boolean favColor, boolean favAnimal, boolean email, boolean job, boolean car)
    {
        FakeDataDTO fakeDataDTO = new FakeDataDTO();
        Faker faker = new Faker(locale);

        for (int i = 0; i < num; i++) {
            Person person = new Person();
            person.setName(faker.name().firstName());
            person.setSurname(faker.name().lastName());
            person.setBirthDate(faker.date().birthday().toLocalDateTime().toLocalDate());

            if (address) {
                person.setAddress(faker.address().streetAddress());
            }
            if (university) {
                person.setUniversity(faker.university().name());
            }
            if (country) {
                person.setCountryOfOrigin(faker.address().country());
            }
            if (favColor) {
                person.setFavoriteColor(faker.color().name());
            }
            if (favAnimal) {
                person.setFavoriteAnimal(faker.animal().name());
            }
            if (email) {
                person.setEmail(faker.internet().emailAddress());
            }
            if (job) {
                person.setJob(faker.job().title());
            }
            if (car) {
                person.setCar(faker.vehicle().model());
            }

            fakeDataDTO.addPerson(person);
        }
        return fakeDataDTO;
    }
}
