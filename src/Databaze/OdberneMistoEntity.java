package Databaze;

import javax.persistence.*;

/**
 * Created by stepanmudra on 15.01.17.
 */
@Entity
@Table(name = "OdberneMisto", schema = "", catalog = "")
public class OdberneMistoEntity {
    private int ean;
    private String adresa;

    @Id
    @Column(name = "ean")
    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    @Basic
    @Column(name = "adresa")
    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OdberneMistoEntity that = (OdberneMistoEntity) o;

        if (ean != that.ean) return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ean;
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        return result;
    }
}
