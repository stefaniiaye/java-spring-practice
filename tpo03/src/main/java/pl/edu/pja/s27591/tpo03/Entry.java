package pl.edu.pja.s27591.tpo03;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eng;
    private String de;
    private String pl;

    public Entry( String eng, String de, String pl) {
        this.eng = eng;
        this.de = de;
        this.pl = pl;
    }
    public Entry() {
    }

    public String getEng() {
        return eng;
    }

    public String getDe() {
        return de;
    }

    public String getPl() {
        return pl;
    }

    public Long getId() {
        return id;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    @Override
    public String toString() {
        return "(Eng) " + eng + "\t" +
                "(De) " + de + "\t" +
                "(Pl) " + pl ;
    }
}
