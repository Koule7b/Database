package Databaze;

import javax.persistence.*;

/**
 * Created by stepanmudra on 15.01.17.
 */
@Entity
@Table(name = "Produkty", schema = "", catalog = "")
public class ProduktyEntity {
    private int id;
    private int cena;
    private String popis;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cena")
    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Basic
    @Column(name = "popis")
    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProduktyEntity that = (ProduktyEntity) o;

        if (id != that.id) return false;
        if (cena != that.cena) return false;
        if (popis != null ? !popis.equals(that.popis) : that.popis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cena;
        result = 31 * result + (popis != null ? popis.hashCode() : 0);
        return result;
    }
}
