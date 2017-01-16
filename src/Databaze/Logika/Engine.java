package Databaze.Logika;

import Databaze.*;
import Databaze.Grafika.OknoChyby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Engine {

    Session session;
    SessionFactory sessionFactory;
    public Engine(Session session){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public void vytvorZakaznika(int id, String jmeno, String prijmeni, String adresa){
        session = sessionFactory.openSession();
        ZakaznikEntity zakaznikEntity = new ZakaznikEntity();
        zakaznikEntity.setId(id);
        zakaznikEntity.setJmeno(jmeno);
        zakaznikEntity.setPrijmeni(prijmeni);
        zakaznikEntity.setAdresa(adresa);
        List<ZakaznikEntity> ze = session.createCriteria(ZakaznikEntity.class).list();
        for (int i = 0; i < ze.size(); i++) {
            if(id == ze.get(i).getId()){
                OknoChyby oknoChyby = new OknoChyby();
                oknoChyby.vypisChybu();
                return;
            }
        }
        session.beginTransaction();
        session.save(zakaznikEntity);
        session.getTransaction().commit();
        session.close();
        //if(transaction.isActive()){
            //transaction.rollback();
        //}
    }
    public void vytvorMistoOdberu(int id, String adresa){
        session = sessionFactory.openSession();
        OdberneMistoEntity odberneMistoEntity = new OdberneMistoEntity();
        odberneMistoEntity.setEan(id);
        odberneMistoEntity.setAdresa(adresa);
        session.beginTransaction();
        session.save(odberneMistoEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorPlatbu(int id, String datum, int castka, int idSmlouvy){
        session = sessionFactory.openSession();
        PlatbaEntity platbaEntity = new PlatbaEntity();
        platbaEntity.setId(id);
        platbaEntity.setDatum(datum);
        platbaEntity.setCastka(castka);
        platbaEntity.setIdSmlovy(idSmlouvy);
        session.beginTransaction();
        session.save(platbaEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorProdukt(int id, int cena, String popis){
        session = sessionFactory.openSession();
        ProduktyEntity produktyEntity = new ProduktyEntity();
        produktyEntity.setId(id);
        produktyEntity.setCena(cena);
        produktyEntity.setPopis(popis);
        session.beginTransaction();
        session.save(produktyEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorMereni(int id, String datum, int hodnota, int idMista){
        session = sessionFactory.openSession();
        MereniEntity mereniEntity = new MereniEntity();
        mereniEntity.setId(id);
        mereniEntity.setDatum(datum);
        mereniEntity.setHodnota(hodnota);
        mereniEntity.setMistoOdberu(idMista);
        session.beginTransaction();
        session.save(mereniEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorSmlouvu(int id, String datumP, String datumV, int idZ, int idP, int idMO){
        session = sessionFactory.openSession();
        SmlouvaEntity smlouvaEntity = new SmlouvaEntity();
        smlouvaEntity.setId(id);
        smlouvaEntity.setDatumPocatku(datumP);
        smlouvaEntity.setDatumVyprseni(datumV);
        smlouvaEntity.setIdZakaznika(idZ);
        smlouvaEntity.setIdProduktu(idP);
        smlouvaEntity.setIdMistaOdberu(idMO);
        session.beginTransaction();
        session.save(smlouvaEntity);
        session.getTransaction().commit();
        session.close();
    }
    public Object[][] vypisMereni(){
        session = sessionFactory.openSession();
        List<MereniEntity> mereniEntities;
        mereniEntities = session.createCriteria(MereniEntity.class).list();
        Object[][] arr = new Object[mereniEntities.size()][];
        for (int i = 0; i < mereniEntities.size(); i++) {
            arr[i] = new Object[]{mereniEntities.get(i).getId(), mereniEntities.get(i).getDatum(), mereniEntities.get(i).getHodnota(), mereniEntities.get(i).getMistoOdberu()};
        }
        session.close();
        return arr;
    }
    public Object[][] vypisMistaOdberu(){
        session = sessionFactory.openSession();
        List<OdberneMistoEntity> odberneMistoEntities;
        odberneMistoEntities = session.createCriteria(OdberneMistoEntity.class).list();
        Object[][] arr = new Object[odberneMistoEntities.size()][];
        for (int i = 0; i < odberneMistoEntities.size(); i++) {
            arr[i] = new Object[]{odberneMistoEntities.get(i).getEan(), odberneMistoEntities.get(i).getAdresa()};
        }
        session.close();
        return arr;
    }
    public Object[][] vypisPlatby(){
        session = sessionFactory.openSession();
        List<PlatbaEntity> platbaEntities;
        platbaEntities = session.createCriteria(PlatbaEntity.class).list();
        Object[][] arr = new Object[platbaEntities.size()][];
        for (int i = 0; i < platbaEntities.size(); i++) {
            arr[i] = new Object[]{platbaEntities.get(i).getId(), platbaEntities.get(i).getCastka(), platbaEntities.get(i).getDatum(), platbaEntities.get(i).getIdSmlovy()};
        }
        session.close();
        return arr;
    }
    public Object[][] vypisProdukty(){
        session = sessionFactory.openSession();
        List<ProduktyEntity> produktyEntities;
        produktyEntities = session.createCriteria(ProduktyEntity.class).list();
        Object[][] arr = new Object[produktyEntities.size()][];
        for (int i = 0; i < produktyEntities.size(); i++) {
            arr[i] = new Object[]{produktyEntities.get(i).getId(), produktyEntities.get(i).getCena(), produktyEntities.get(i).getPopis()};
        }
        session.close();
        return arr;
    }
    public Object[][] vypisSmlouvy(){
        session = sessionFactory.openSession();
        List<SmlouvaEntity> smlouvaEntities;
        smlouvaEntities = session.createCriteria(SmlouvaEntity.class).list();
        Object[][] arr = new Object[smlouvaEntities.size()][];
        for (int i = 0; i < smlouvaEntities.size(); i++) {
            arr[i] = new Object[]{smlouvaEntities.get(i).getId(), smlouvaEntities.get(i).getDatumPocatku(), smlouvaEntities.get(i).getDatumVyprseni(), smlouvaEntities.get(i).getIdMistaOdberu(), smlouvaEntities.get(i).getIdProduktu(), smlouvaEntities.get(i).getIdZakaznika()};
        }
        session.close();
        return arr;
    }
    public Object[][] vypisZakazniky(){
        session = sessionFactory.openSession();
        List<ZakaznikEntity> zakaznikEntities;
        zakaznikEntities = session.createCriteria(ZakaznikEntity.class).list();
        Object[][] arr = new Object[zakaznikEntities.size()][];
        for (int i = 0; i < zakaznikEntities.size(); i++) {
            arr[i] = new Object[]{zakaznikEntities.get(i).getId(), zakaznikEntities.get(i).getAdresa(), zakaznikEntities.get(i).getJmeno(), zakaznikEntities.get(i).getPrijmeni()};
        }
        session.close();
        return arr;
    }
}
