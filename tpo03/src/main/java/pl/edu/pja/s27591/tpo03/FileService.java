package pl.edu.pja.s27591.tpo03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class FileService {
    private String fileName;
    private EntryRepoInterface repo;

    public FileService(@Value("${pl.edu.pja.tpo02.filename}") String filename, EntryRepoInterface entryRepoInterface) {
        this.fileName = filename;
        this.repo = entryRepoInterface;
        readFile();
    }

    public void readFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    Entry entry = new Entry(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    repo.addEntry(entry);
                } else {
                    System.out.println("Invalid entry format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addNewEntry(Entry e) throws IOException {
        repo.addEntry(e);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.append("\n");
        bw.append(e.getEng() + ";" + e.getDe() + ";" + e.getPl());
        bw.close();
    }
}
