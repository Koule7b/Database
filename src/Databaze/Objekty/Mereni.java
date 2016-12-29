package Databaze.Objekty;

import java.util.Calendar;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Mereni {
    private int id;
    private int idMistaOdberu;
    private Calendar datum;
    private int hodnota;

    public Mereni(int id, int idMistaOdberu, Calendar datum, int hodnota) {
        this.id = id;
        this.datum = datum;
        this.hodnota = hodnota;
        this.idMistaOdberu = idMistaOdberu;
    }

    public int getId() {
        return id;
    }

    public Calendar getDatum() {
        return datum;
    }

    public int getHodnota() {
        return hodnota;
    }

    public int getIdMistaOdberu() {
        return idMistaOdberu;
    }
}
