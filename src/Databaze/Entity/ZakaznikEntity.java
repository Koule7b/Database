package Databaze.Entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by stepanmudra on 31.01.17.
 */
@Entity
@Table(name = "Zakaznik", schema = "", catalog = "")
public class ZakaznikEntity {
    private int id;
    private String jmeno;
    private String prijmeni;
    private String adresa;
    private Collection<SmlouvaEntity> smlouvasById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jmeno", nullable = false, length = 0)
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    @Basic
    @Column(name = "prijmeni", nullable = false, length = 0)
    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
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

        ZakaznikEntity that = (ZakaznikEntity) o;

        if (id != that.id) return false;
        if (jmeno != null ? !jmeno.equals(that.jmeno) : that.jmeno != null) return false;
        if (prijmeni != null ? !prijmeni.equals(that.prijmeni) : that.prijmeni != null) return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (jmeno != null ? jmeno.hashCode() : 0);
        result = 31 * result + (prijmeni != null ? prijmeni.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "zakaznikByIdZakaznika")
    public Collection<SmlouvaEntity> getSmlouvasById() {
        return smlouvasById;
    }

    public void setSmlouvasById(Collection<SmlouvaEntity> smlouvasById) {
        this.smlouvasById = smlouvasById;
    }
}
