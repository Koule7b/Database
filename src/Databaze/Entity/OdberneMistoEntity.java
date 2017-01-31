package Databaze.Entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by stepanmudra on 31.01.17.
 */
@Entity
@Table(name = "OdberneMisto", schema = "", catalog = "")
public class OdberneMistoEntity {
    private int ean;
    private String adresa;
    private Collection<MereniEntity> merenisByEan;
    private SmlouvaEntity smlouvaByEan;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

    @Basic
    @Column(name = "adresa", nullable = false, length = 0)
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

    @OneToMany(mappedBy = "odberneMistoByMistoOdberu")
    public Collection<MereniEntity> getMerenisByEan() {
        return merenisByEan;
    }

    public void setMerenisByEan(Collection<MereniEntity> merenisByEan) {
        this.merenisByEan = merenisByEan;
    }

    @OneToOne(mappedBy = "odberneMistoByIdMistaOdberu")
    public SmlouvaEntity getSmlouvaByEan() {
        return smlouvaByEan;
    }

    public void setSmlouvaByEan(SmlouvaEntity smlouvaByEan) {
        this.smlouvaByEan = smlouvaByEan;
    }
}
