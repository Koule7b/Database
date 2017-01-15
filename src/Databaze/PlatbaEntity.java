package Databaze;

import javax.persistence.*;

/**
 * Created by stepanmudra on 15.01.17.
 */
@Entity
@Table(name = "Platba", schema = "", catalog = "")
public class PlatbaEntity {
    private int id;
    private String datum;
    private int castka;
    private int idSmlovy;

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
    @Column(name = "castka")
    public int getCastka() {
        return castka;
    }

    public void setCastka(int castka) {
        this.castka = castka;
    }

    @Basic
    @Column(name = "idSmlovy")
    public int getIdSmlovy() {
        return idSmlovy;
    }

    public void setIdSmlovy(int idSmlovy) {
        this.idSmlovy = idSmlovy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatbaEntity that = (PlatbaEntity) o;

        if (id != that.id) return false;
        if (castka != that.castka) return false;
        if (idSmlovy != that.idSmlovy) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + castka;
        result = 31 * result + idSmlovy;
        return result;
    }
}
