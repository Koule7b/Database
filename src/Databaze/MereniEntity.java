package Databaze;

import javax.persistence.*;

/**
 * Created by stepanmudra on 15.01.17.
 */
@Entity
@Table(name = "Mereni", schema = "", catalog = "")
public class MereniEntity {
    private int id;
    private String datum;
    private int hodnota;
    private int mistoOdberu;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datum")
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Basic
    @Column(name = "hodnota")
    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    @Basic
    @Column(name = "mistoOdberu")
    public int getMistoOdberu() {
        return mistoOdberu;
    }

    public void setMistoOdberu(int mistoOdberu) {
        this.mistoOdberu = mistoOdberu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MereniEntity that = (MereniEntity) o;

        if (id != that.id) return false;
        if (hodnota != that.hodnota) return false;
        if (mistoOdberu != that.mistoOdberu) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + hodnota;
        result = 31 * result + mistoOdberu;
        return result;
    }
}
