package Databaze.Fasady;

import Databaze.Entity.OdberneMistoEntity;
import Databaze.Entity.ProduktyEntity;
import Databaze.Entity.SmlouvaEntity;
import Databaze.Entity.ZakaznikEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by stepanmudra on 18.01.17.
 */
public class Smlouva {
    SessionFactory sessionFactory;
    public Smlouva(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void novaSmlouva(String datumPocatku, String datumVyprseni, ZakaznikEntity zakaznik, ProduktyEntity produkt, OdberneMistoEntity mistoOdberu){
        SmlouvaEntity smlouva = new SmlouvaEntity();
        smlouva.setDatumPocatku(datumPocatku);
        smlouva.setDatumVyprseni(datumVyprseni);
        smlouva.setZakaznikByIdZakaznika(zakaznik);
        smlouva.setProduktyByIdProduktu(produkt);
        smlouva.setOdberneMistoByIdMistaOdberu(mistoOdberu);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(smlouva);
        session.close();
    }
    public void zmenaSmlouvy(SmlouvaEntity smlova, String datumPocatku, String datumVyprseni, ZakaznikEntity zakaznik, ProduktyEntity produkt, OdberneMistoEntity mistoOdberu){
        smlova.setDatumPocatku(datumPocatku);
        smlova.setDatumVyprseni(datumVyprseni);
        smlova.setZakaznikByIdZakaznika(zakaznik);
        smlova.setProduktyByIdProduktu(produkt);
        smlova.setOdberneMistoByIdMistaOdberu(mistoOdberu);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(smlova);
        session.close();
    }
    public List<SmlouvaEntity> getSeznamSmluv(){
        List<SmlouvaEntity> seznamSmluv;
        Session session = sessionFactory.openSession();
        seznamSmluv = session.createCriteria(SmlouvaEntity.class).list();
        return seznamSmluv;
    }
    public SmlouvaEntity najdiSmlouvu(int id){
        Session session = sessionFactory.openSession();
        SmlouvaEntity smlouva = session.get(SmlouvaEntity.class, id);
        session.close();
        return smlouva;
    }
    public void smazSmlouvu(SmlouvaEntity smlouva){

    }
}
