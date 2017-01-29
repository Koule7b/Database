package Databaze.Entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by stepanmudra on 15.01.17.
 */
@Entity
@Table(name = "Smlouva", schema = "", catalog = "")
public class SmlouvaEntity {
    private int id;
    private String datumPocatku;
    private String datumVyprseni;
    private int idZakaznika;
    private Integer idProduktu;
    private Integer idMistaOdberu;
    private Collection<PlatbaEntity> platbasById;
    private ZakaznikEntity zakaznikByIdZakaznika;
    private ProduktyEntity produktyByIdProduktu;
    private OdberneMistoEntity odberneMistoByIdMistaOdberu;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datumPocatku")
    public String getDatumPocatku() {
        return datumPocatku;
    }

    public void setDatumPocatku(String datumPocatku) {
        this.datumPocatku = datumPocatku;
    }

    @Basic
    @Column(name = "datumVyprseni")
    public String getDatumVyprseni() {
        return datumVyprseni;
    }

    public void setDatumVyprseni(String datumVyprseni) {
        this.datumVyprseni = datumVyprseni;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmlouvaEntity that = (SmlouvaEntity) o;

        if (id != that.id) return false;
        if (idZakaznika != that.idZakaznika) return false;
        if (datumPocatku != null ? !datumPocatku.equals(that.datumPocatku) : that.datumPocatku != null) return false;
        if (datumVyprseni != null ? !datumVyprseni.equals(that.datumVyprseni) : that.datumVyprseni != null)
            return false;
        if (idProduktu != null ? !idProduktu.equals(that.idProduktu) : that.idProduktu != null) return false;
        if (idMistaOdberu != null ? !idMistaOdberu.equals(that.idMistaOdberu) : that.idMistaOdberu != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datumPocatku != null ? datumPocatku.hashCode() : 0);
        result = 31 * result + (datumVyprseni != null ? datumVyprseni.hashCode() : 0);
        result = 31 * result + idZakaznika;
        result = 31 * result + (idProduktu != null ? idProduktu.hashCode() : 0);
        result = 31 * result + (idMistaOdberu != null ? idMistaOdberu.hashCode() : 0);
        return result;
    }


    @OneToMany(mappedBy = "smlouvaByIdSmlovy")
    public Collection<PlatbaEntity> getPlatbasById() {
        return platbasById;
    }

    public void setPlatbasById(Collection<PlatbaEntity> platbasById) {
        this.platbasById = platbasById;
    }

    @ManyToOne
    @JoinColumn(name = "idZakaznika", referencedColumnName = "id", nullable = false)
    public ZakaznikEntity getZakaznikByIdZakaznika() {
        return zakaznikByIdZakaznika;
    }

    public void setZakaznikByIdZakaznika(ZakaznikEntity zakaznikByIdZakaznika) {
        this.zakaznikByIdZakaznika = zakaznikByIdZakaznika;
    }

    @ManyToOne
    @JoinColumn(name = "idProduktu", referencedColumnName = "id")
    public ProduktyEntity getProduktyByIdProduktu() {
        return produktyByIdProduktu;
    }

    public void setProduktyByIdProduktu(ProduktyEntity produktyByIdProduktu) {
        this.produktyByIdProduktu = produktyByIdProduktu;
    }

    @OneToOne
    @JoinColumn(name = "idMistaOdberu", referencedColumnName = "ean")
    public OdberneMistoEntity getOdberneMistoByIdMistaOdberu() {
        return odberneMistoByIdMistaOdberu;
    }

    public void setOdberneMistoByIdMistaOdberu(OdberneMistoEntity odberneMistoByIdMistaOdberu) {
        this.odberneMistoByIdMistaOdberu = odberneMistoByIdMistaOdberu;
    }
}