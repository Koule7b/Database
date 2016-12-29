import java.util.ArrayList;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Zakaznik {
    private int id;
    private int RCICO;
    private ArrayList<Character> jmeno;
    private ArrayList<Character> prijmeni;
    private ArrayList<Character> adresa;

    public Zakaznik(int id, int RCICO, ArrayList<Character> jmeno, ArrayList<Character> prijmeni, ArrayList<Character> adresa) {
        this.id = id;
        this.RCICO = RCICO;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.adresa = adresa;
    }

    public int getId() {
        return id;
    }

    public int getRCICO() {
        return RCICO;
    }

    public ArrayList<Character> getJmeno() {
        return jmeno;
    }

    public ArrayList<Character> getPrijmeni() {
        return prijmeni;
    }

    public ArrayList<Character> getAdresa() {
        return adresa;
    }
}
