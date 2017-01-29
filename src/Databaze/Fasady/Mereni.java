package Databaze.Fasady;

import Databaze.Entity.MereniEntity;
import Databaze.Entity.OdberneMistoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by stepanmudra on 20.01.17.
 */
public class Mereni {
    SessionFactory sessionFactory;

    public Mereni(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void noveMereni(String datum, int hodnota, OdberneMistoEntity mistoOdberu){
        MereniEntity mereni = new MereniEntity();
        mereni.setDatum(datum);
        mereni.setHodnota(hodnota);
        mereni.setOdberneMistoByMistoOdberu(mistoOdberu);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(mereni);
        session.close();
    }

    public void zmenMereni(MereniEntity mereniEntity, String datum, int hodnota, OdberneMistoEntity misto){
        mereniEntity.setDatum(datum);
        mereniEntity.setHodnota(hodnota);
        mereniEntity.setOdberneMistoByMistoOdberu(misto);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(mereniEntity);
        session.close();
    }

    public MereniEntity najdiMereni(int id){
        Session session = sessionFactory.openSession();
        MereniEntity mereni = session.get(MereniEntity.class, id);
        session.close();
        return mereni;
    }

    public List<MereniEntity> getSeznamMereni(){
        Session session = sessionFactory.openSession();
        List<MereniEntity> seznamMereni = session.createCriteria(MereniEntity.class).list();
        session.close();
        return seznamMereni;
    }

    public void smazMereni(MereniEntity mereniEntity){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(mereniEntity);
        session.close();
    }
}
