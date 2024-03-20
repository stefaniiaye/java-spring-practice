package pl.edu.pja.s27591.tpo03;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntryRepository implements EntryRepoInterface {
    private List<Entry> entryList;

    public EntryRepository() {
        this.entryList = new ArrayList<>();
    }

    @Override
    public void addEntry(Entry e) {
        entryList.add(e);
    }

    @Override
    public List<Entry> getEntries() {
        return entryList;
    }

}
