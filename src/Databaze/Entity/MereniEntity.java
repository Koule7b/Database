package Databaze.Entity;

import javax.persistence.*;

/**
 * Created by stepanmudra on 31.01.17.
 */
@Entity
@Table(name = "Mereni", schema = "", catalog = "")
public class MereniEntity {
    private int id;
    private int hodnota;
    private String datum;
    private OdberneMistoEntity odberneMistoByMistoOdberu;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hodnota", nullable = false)
    public int getHodnota() {
        return hodnota;
    }

    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }

    @Basic
    @Column(name = "datum", nullable = true, length = 0)
    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MereniEntity that = (MereniEntity) o;

        if (id != that.id) return false;
        if (hodnota != that.hodnota) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + hodnota;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "mistoOdberu", referencedColumnName = "ean", nullable = false)
    public OdberneMistoEntity getOdberneMistoByMistoOdberu() {
        return odberneMistoByMistoOdberu;
    }

    public void setOdberneMistoByMistoOdberu(OdberneMistoEntity odberneMistoByMistoOdberu) {
        this.odberneMistoByMistoOdberu = odberneMistoByMistoOdberu;
    }
}
