package Databaze.Logika;

import Databaze.Entity.*;
import Databaze.Grafika.OknoChyby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Engine {

    SessionFactory sessionFactory;
    public Engine(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void zmenZakaznika(int id, String jmeno, String prijmeni, String adresa){
            for (int i = 0; i < vypisZakazniky().length; i++) {
                if (vypisZakazniky()[i][0].equals(id)) {
                    Session session = sessionFactory.openSession();
                    session.remove(session.createCriteria(ZakaznikEntity.class).list().get(i));
                    session.beginTransaction();
                    session.getTransaction().commit();
                    session.close();
                    ZakaznikEntity zakaznikEntity = new ZakaznikEntity();
                    zakaznikEntity.setId(id);
                    zakaznikEntity.setJmeno(jmeno);
                    zakaznikEntity.setPrijmeni(prijmeni);
                    zakaznikEntity.setAdresa(adresa);
                    session = sessionFactory.openSession();
                    session.beginTransaction();
                    session.save(zakaznikEntity);
                    session.getTransaction().commit();
                    session.close();
                }
            }
    }
    public void vytvorZakaznika(int id, String jmeno, String prijmeni, String adresa){
        ZakaznikEntity zakaznikEntity = new ZakaznikEntity();
        zakaznikEntity.setId(id);
        zakaznikEntity.setJmeno(jmeno);
        zakaznikEntity.setPrijmeni(prijmeni);
        zakaznikEntity.setAdresa(adresa);
        Session session = sessionFactory.openSession();
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
        OdberneMistoEntity odberneMistoEntity = new OdberneMistoEntity();
        odberneMistoEntity.setEan(id);
        odberneMistoEntity.setAdresa(adresa);
        Session session = sessionFactory.openSession();
        List<OdberneMistoEntity> ze = session.createCriteria(OdberneMistoEntity.class).list();
        for (int i = 0; i < ze.size(); i++) {
            if(id == ze.get(i).getEan()){
                OknoChyby oknoChyby = new OknoChyby();
                oknoChyby.vypisChybu();
                return;
            }
        }
        session.beginTransaction();
        session.save(odberneMistoEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorPlatbu(int id, String datum, int castka, SmlouvaEntity smlouva){
        PlatbaEntity platbaEntity = new PlatbaEntity();
        platbaEntity.setId(id);
        platbaEntity.setDatum(datum);
        platbaEntity.setCastka(castka);
        platbaEntity.setSmlouvaByIdSmlovy(smlouva);
        Session session = sessionFactory.openSession();
        List<PlatbaEntity> ze = session.createCriteria(PlatbaEntity.class).list();
        for (int i = 0; i < ze.size(); i++) {
            if(id == ze.get(i).getId()){
                OknoChyby oknoChyby = new OknoChyby();
                oknoChyby.vypisChybu();
                return;
            }
        }
        session.beginTransaction();
        session.save(platbaEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorProdukt(int id, int cena, String popis){
        ProduktyEntity produktyEntity = new ProduktyEntity();
        produktyEntity.setId(id);
        produktyEntity.setCena(cena);
        produktyEntity.setPopis(popis);
        Session session = sessionFactory.openSession();
        List<ProduktyEntity> ze = session.createCriteria(ProduktyEntity.class).list();
        for (int i = 0; i < ze.size(); i++) {
            if(id == ze.get(i).getId()){
                OknoChyby oknoChyby = new OknoChyby();
                oknoChyby.vypisChybu();
                return;
            }
        }
        session.beginTransaction();
        session.save(produktyEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorMereni(int id, String datum, int hodnota, int idMista){
        MereniEntity mereniEntity = new MereniEntity();
        mereniEntity.setId(id);
        mereniEntity.setDatum(datum);
        mereniEntity.setHodnota(hodnota);
        mereniEntity.setMistoOdberu(idMista);
        Session session = sessionFactory.openSession();
        List<MereniEntity> ze = session.createCriteria(MereniEntity.class).list();
        for (int i = 0; i < ze.size(); i++) {
            if(id == ze.get(i).getId()){
                OknoChyby oknoChyby = new OknoChyby();
                oknoChyby.vypisChybu();
                return;
            }
        }
        session.beginTransaction();
        session.save(mereniEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void vytvorSmlouvu(int id, String datumP, String datumV, int idZ, int idP, int idMO){
        SmlouvaEntity smlouvaEntity = new SmlouvaEntity();
        smlouvaEntity.setId(id);
        smlouvaEntity.setDatumPocatku(datumP);
        smlouvaEntity.setDatumVyprseni(datumV);
        //smlouvaEntity.setIdZakaznika(idZ);
        //smlouvaEntity.setIdProduktu(idP);
        //smlouvaEntity.setIdMistaOdberu(idMO);
        Session session = sessionFactory.openSession();
        List<SmlouvaEntity> ze = session.createCriteria(SmlouvaEntity.class).list();
        for (int i = 0; i < ze.size(); i++) {
            if(id == ze.get(i).getId()){
                OknoChyby oknoChyby = new OknoChyby();
                oknoChyby.vypisChybu();
                return;
            }
        }
        session.beginTransaction();
        session.save(smlouvaEntity);
        session.getTransaction().commit();
        session.close();
    }
    public List<MereniEntity> vypisMereni(){
        List<MereniEntity> mereniEntities;
        Session session = sessionFactory.openSession();
        mereniEntities = session.createCriteria(MereniEntity.class).list();
        session.close();
        return mereniEntities;
    }
    public Object[][] vypisMistaOdberu(){
        Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
        List<PlatbaEntity> platbaEntities;
        platbaEntities = session.createCriteria(PlatbaEntity.class).list();
        Object[][] arr = new Object[platbaEntities.size()][];
        for (int i = 0; i < platbaEntities.size(); i++) {
            //arr[i] = new Object[]{platbaEntities.get(i).getId(), platbaEntities.get(i).getCastka(), platbaEntities.get(i).getDatum(), platbaEntities.get(i).getIdSmlovy()};
        }
        session.close();
        return arr;
    }
    public Object[][] vypisProdukty(){
        Session session = sessionFactory.openSession();
        List<ProduktyEntity> produktyEntities;
        produktyEntities = session.createCriteria(ProduktyEntity.class).list();
        Object[][] arr = new Object[produktyEntities.size()][];
        for (int i = 0; i < produktyEntities.size(); i++) {
            arr[i] = new Object[]{produktyEntities.get(i).getId(), produktyEntities.get(i).getCena(), produktyEntities.get(i).getPopis()};
        }
        session.close();
        return arr;
    }
    public List<SmlouvaEntity> vypisSmlouvy(){
        Session session = sessionFactory.openSession();
        List<SmlouvaEntity> smlouvaEntities = session.createCriteria(SmlouvaEntity.class).list();
        session.close();
        return smlouvaEntities;
    }
    public Object[][] vypisZakazniky(){
        Session session = sessionFactory.openSession();
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
