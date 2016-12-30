package Databaze.Model;

import java.util.Collection;

/**
 * Created by stepanmudra on 30.12.16.
 */
public class SmlouvaEntity {
    private int id;
    private String datumPocatku;
    private String datumVyprseni;
    private int idZakaznika;
    private int idMistaOdberu;
    private int idProduktu;
    private Collection<PlatbaEntity> platbasById;
    private ZakaznikEntity zakaznikByIdZakaznika;
    private OdberneMistoEntity odberneMistoByIdMistaOdberu;
    private ProduktyEntity produktyByIdProduktu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatumPocatku() {
        return datumPocatku;
    }

    public void setDatumPocatku(String datumPocatku) {
        this.datumPocatku = datumPocatku;
    }

    public String getDatumVyprseni() {
        return datumVyprseni;
    }

    public void setDatumVyprseni(String datumVyprseni) {
        this.datumVyprseni = datumVyprseni;
    }

    public int getIdZakaznika() {
        return idZakaznika;
    }

    public void setIdZakaznika(int idZakaznika) {
        this.idZakaznika = idZakaznika;
    }

    public int getIdMistaOdberu() {
        return idMistaOdberu;
    }

    public void setIdMistaOdberu(int idMistaOdberu) {
        this.idMistaOdberu = idMistaOdberu;
    }

    public int getIdProduktu() {
        return idProduktu;
    }

    public void setIdProduktu(int idProduktu) {
        this.idProduktu = idProduktu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmlouvaEntity that = (SmlouvaEntity) o;

        if (id != that.id) return false;
        if (idZakaznika != that.idZakaznika) return false;
        if (idMistaOdberu != that.idMistaOdberu) return false;
        if (idProduktu != that.idProduktu) return false;
        if (datumPocatku != null ? !datumPocatku.equals(that.datumPocatku) : that.datumPocatku != null) return false;
        if (datumVyprseni != null ? !datumVyprseni.equals(that.datumVyprseni) : that.datumVyprseni != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datumPocatku != null ? datumPocatku.hashCode() : 0);
        result = 31 * result + (datumVyprseni != null ? datumVyprseni.hashCode() : 0);
        result = 31 * result + idZakaznika;
        result = 31 * result + idMistaOdberu;
        result = 31 * result + idProduktu;
        return result;
    }

    public Collection<PlatbaEntity> getPlatbasById() {
        return platbasById;
    }

    public void setPlatbasById(Collection<PlatbaEntity> platbasById) {
        this.platbasById = platbasById;
    }

    public ZakaznikEntity getZakaznikByIdZakaznika() {
        return zakaznikByIdZakaznika;
    }

    public void setZakaznikByIdZakaznika(ZakaznikEntity zakaznikByIdZakaznika) {
        this.zakaznikByIdZakaznika = zakaznikByIdZakaznika;
    }

    public OdberneMistoEntity getOdberneMistoByIdMistaOdberu() {
        return odberneMistoByIdMistaOdberu;
    }

    public void setOdberneMistoByIdMistaOdberu(OdberneMistoEntity odberneMistoByIdMistaOdberu) {
        this.odberneMistoByIdMistaOdberu = odberneMistoByIdMistaOdberu;
    }

    public ProduktyEntity getProduktyByIdProduktu() {
        return produktyByIdProduktu;
    }

    public void setProduktyByIdProduktu(ProduktyEntity produktyByIdProduktu) {
        this.produktyByIdProduktu = produktyByIdProduktu;
    }
}
