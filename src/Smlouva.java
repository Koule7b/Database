import java.util.Calendar;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Smlouva {
    private int id;
    private int idZakaznika;
    private int idMistaOdberu;
    private int idProduktu;
    private Calendar datumPocatku;
    private Calendar datumVyprseni;

    public Smlouva(int id, int idZakaznika, int idMistaOdberu, int idProduktu, Calendar datumPocatku, Calendar datumVyprseni) {
        this.id = id;
        this.idZakaznika = idZakaznika;
        this.idMistaOdberu = idMistaOdberu;
        this.idProduktu = idProduktu;
        this.datumPocatku = datumPocatku;
        this.datumVyprseni = datumVyprseni;
    }

    public int getId() {
        return id;
    }

    public int getIdZakaznika() {
        return idZakaznika;
    }

    public int getIdMistaOdberu() {
        return idMistaOdberu;
    }

    public int getIdProduktu() {
        return idProduktu;
    }

    public Calendar getDatumPocatku() {
        return datumPocatku;
    }

    public Calendar getDatumVyprseni() {
        return datumVyprseni;
    }
}
