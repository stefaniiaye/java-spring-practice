package pjwstk.edu.pl.s27591.tpo06.model;

import java.util.HashSet;
import java.util.Set;

public class FakeDataDTO {
    private Set<Person> personSet;

    public FakeDataDTO() {
        this.personSet = new HashSet<>();
    }

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void addPerson(Person person){
        personSet.add(person);
    }
}
