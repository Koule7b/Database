package Databaze.Model;

import java.util.Collection;

/**
 * Created by stepanmudra on 30.12.16.
 */
public class OdberneMistoEntity {
    private int ean;
    private String adresa;
    private Collection<MereniEntity> merenisByEan;
    private Collection<SmlouvaEntity> smlouvasByEan;

    public int getEan() {
        return ean;
    }

    public void setEan(int ean) {
        this.ean = ean;
    }

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

    public Collection<MereniEntity> getMerenisByEan() {
        return merenisByEan;
    }

    public void setMerenisByEan(Collection<MereniEntity> merenisByEan) {
        this.merenisByEan = merenisByEan;
    }

    public Collection<SmlouvaEntity> getSmlouvasByEan() {
        return smlouvasByEan;
    }

    public void setSmlouvasByEan(Collection<SmlouvaEntity> smlouvasByEan) {
        this.smlouvasByEan = smlouvasByEan;
    }
}
