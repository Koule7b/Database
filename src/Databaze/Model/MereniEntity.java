package Databaze.Model;

/**
 * Created by stepanmudra on 30.12.16.
 */
public class MereniEntity {
    private int id;
    private String datum;
    private int hodnota;
    private int idMistaOdberu;
    private OdberneMistoEntity odberneMistoByIdMistaOdberu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    public int getIdMistaOdberu() {
        return idMistaOdberu;
    }

    public void setIdMistaOdberu(int idMistaOdberu) {
        this.idMistaOdberu = idMistaOdberu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MereniEntity that = (MereniEntity) o;

        if (id != that.id) return false;
        if (hodnota != that.hodnota) return false;
        if (idMistaOdberu != that.idMistaOdberu) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + hodnota;
        result = 31 * result + idMistaOdberu;
        return result;
    }

    public OdberneMistoEntity getOdberneMistoByIdMistaOdberu() {
        return odberneMistoByIdMistaOdberu;
    }

    public void setOdberneMistoByIdMistaOdberu(OdberneMistoEntity odberneMistoByIdMistaOdberu) {
        this.odberneMistoByIdMistaOdberu = odberneMistoByIdMistaOdberu;
    }
}
