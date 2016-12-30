package Databaze.Model;

/**
 * Created by stepanmudra on 30.12.16.
 */
public class PlatbaEntity {
    private int id;
    private String datum;
    private int idSmlouvy;
    private SmlouvaEntity smlouvaByIdSmlouvy;

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

    public int getIdSmlouvy() {
        return idSmlouvy;
    }

    public void setIdSmlouvy(int idSmlouvy) {
        this.idSmlouvy = idSmlouvy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatbaEntity that = (PlatbaEntity) o;

        if (id != that.id) return false;
        if (idSmlouvy != that.idSmlouvy) return false;
        if (datum != null ? !datum.equals(that.datum) : that.datum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datum != null ? datum.hashCode() : 0);
        result = 31 * result + idSmlouvy;
        return result;
    }

    public SmlouvaEntity getSmlouvaByIdSmlouvy() {
        return smlouvaByIdSmlouvy;
    }

    public void setSmlouvaByIdSmlouvy(SmlouvaEntity smlouvaByIdSmlouvy) {
        this.smlouvaByIdSmlouvy = smlouvaByIdSmlouvy;
    }
}
