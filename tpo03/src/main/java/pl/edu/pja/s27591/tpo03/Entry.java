package pl.edu.pja.s27591.tpo03;

public class Entry {
    private String eng;
    private String de;
    private String pl;

    public Entry(String eng, String de, String pl) {
        this.eng = eng;
        this.de = de;
        this.pl = pl;
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
}
