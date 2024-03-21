package pl.edu.pja.s27591.tpo03;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpringDataEntryRepoInterface extends CrudRepository<Entry, Long> {
    // Method to add a new Entry object to the database
    Entry save(Entry entry);

    // Method to retrieve all entries from the database
    List<Entry> findAll();

    // Custom method to search for entries containing a given keyword in their English, German, or Polish fields
    List<Entry> searchEntries(String word);

    // Method to delete an entry by its ID
    void deleteById(Long id);

}
