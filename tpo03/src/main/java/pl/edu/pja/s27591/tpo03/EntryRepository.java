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

    @Override
    public Entry getEntryById(Long id) {
        return entityManager.find(Entry.class, id);
    }

    @Override
    public List<Entry> searchEntries(String query) {
        return entityManager.createQuery("SELECT e FROM Entry e WHERE e.eng LIKE :query OR e.de LIKE :query OR e.pl LIKE :query", Entry.class)
                .setParameter("query", "%" + query + "%")
                .getResultList();
    }

    @Override
    public List<Entry> sortEntriesByLanguage(String language, boolean ascending) {
        String queryString = "SELECT e FROM Entry e ORDER BY ";
        if (language.equals("eng")) {
            queryString += "e.eng";
        } else if (language.equals("de")) {
            queryString += "e.de";
        } else if (language.equals("pl")) {
            queryString += "e.pl";
        }
        queryString += ascending ? " ASC" : " DESC";
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


