package pl.edu.pja.s27591.tpo03;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataEntryRepoInterface extends CrudRepository<Entry, Long> {
    Entry save(Entry entry);

    Optional<Entry> findById(Long id);

    List<Entry> findAll();

    List<Entry> findAll(Sort sort);

    List<Entry> searchEntries(String word);

    void deleteById(Long id);

}
