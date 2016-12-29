package Databaze.Objekty;

import java.util.Calendar;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Platba {
    private int id;
    private int idSmlouvy;
    private Calendar datum;
    private int castka;

    public Platba(int id, Calendar datum, int castka, int idSmlouvy) {
        this.id = id;
        this.idSmlouvy = idSmlouvy;
        this.datum = datum;
        this.castka = castka;
    }

    public int getId() {
        return id;
    }

    public Calendar getDatum() {
        return datum;
    }

    public int getCastka() {
        return castka;
    }

    public int getIdSmlouvy() {
        return idSmlouvy;
    }
}
