package pl.edu.pja.s27591.tpo03;

import java.util.List;

public interface EntryRepoInterface {
    public void addEntry(Entry e);
    public List<Entry> getEntries();

    Entry getEntryById(Long id);
    List<Entry> searchEntries(String query);
    List<Entry> sortEntriesByLanguage(String language, boolean ascending);
    void deleteEntry(Long id);
    void updateEntry(Entry e);

}
