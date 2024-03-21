/*
package pl.edu.pja.s27591.tpo03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EntryRepository implements EntryRepoInterface {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addEntry(Entry e) {
        entityManager.persist(e);
    }

    @Override
    public List<Entry> getEntries() {
        return entityManager.createQuery("SELECT e FROM Entry e", Entry.class).getResultList();
    }

    public Entry getEntryById(Long id) {
        return entityManager.find(Entry.class, id);
    }

    @Override
    public List<Entry> searchEntries(String word) {
        return entityManager.createQuery("SELECT e FROM Entry e WHERE LOWER(e.eng)" +
                        " LIKE LOWER(:word) OR LOWER(e.de) LIKE LOWER(:word) OR LOWER(e.pl) LIKE LOWER(:word)", Entry.class)
                .setParameter("word", "%" + word.toLowerCase() + "%")
                .getResultList();
    }


    @Override
    public List<Entry> sortEntriesByLanguage(String lang, boolean asc) {
        String queryString = "SELECT e FROM Entry e ORDER BY e." + lang
                + (asc ? " ASC" : " DESC");
        return entityManager.createQuery(queryString, Entry.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteEntry(Long id) {
        Entry entry = entityManager.find(Entry.class, id);
        if (entry != null) {
            entityManager.remove(entry);
        }
    }

    @Override
    @Transactional
    public void updateEntry(Entry e) {
        entityManager.merge(e);
    }
}


*/
