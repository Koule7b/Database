package Databaze.Objekty;

import java.util.ArrayList;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Produkty {
    private int id;
    private int cena;
    private int limit;
    private ArrayList<Character> popis;

    public Produkty(int id, int cena, int limit, ArrayList<Character> popis) {
        this.id = id;
        this.cena = cena;
        this.limit = limit;
        this.popis = popis;
    }

    public int getId() {
        return id;
    }

    public int getCena() {
        return cena;
    }

    public int getLimit() {
        return limit;
    }

    public ArrayList<Character> getPopis() {
        return popis;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setPopis(ArrayList<Character> popis) {
        this.popis = popis;
    }
}
