package Databaze.Model;

import java.util.Collection;

/**
 * Created by stepanmudra on 30.12.16.
 */
public class ProduktyEntity {
    private int id;
    private int cena;
    private int limit;
    private String popis;
    private Collection<SmlouvaEntity> smlouvasById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

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
        if (limit != that.limit) return false;
        if (popis != null ? !popis.equals(that.popis) : that.popis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + cena;
        result = 31 * result + limit;
        result = 31 * result + (popis != null ? popis.hashCode() : 0);
        return result;
    }

    public Collection<SmlouvaEntity> getSmlouvasById() {
        return smlouvasById;
    }

    public void setSmlouvasById(Collection<SmlouvaEntity> smlouvasById) {
        this.smlouvasById = smlouvasById;
    }
}
