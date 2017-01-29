package Databaze.Fasady;

import Databaze.Entity.OdberneMistoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by stepanmudra on 20.01.17.
 */
public class MistoOdberu {
    SessionFactory sessionFactory;

    public MistoOdberu(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void noveMistoOdberu(String adresa){
        OdberneMistoEntity odberneMistoEntity = new OdberneMistoEntity();
        odberneMistoEntity.setAdresa(adresa);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(odberneMistoEntity);
        session.close();
    }

    public void zmenOdberneMisto(OdberneMistoEntity odberneMistoEntity, String adresa){
        odberneMistoEntity.setAdresa(adresa);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(odberneMistoEntity);
        session.close();
    }

    public void smazOdberneMisto(OdberneMistoEntity odberneMistoEntity){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(odberneMistoEntity);
        session.close();
    }

    public List<OdberneMistoEntity> vypisMistaOdberu(){
        List<OdberneMistoEntity> seznamMist;

        Session session = sessionFactory.openSession();
        seznamMist = session.createCriteria(OdberneMistoEntity.class).list();
        session.close();
        return seznamMist;
    }

    public OdberneMistoEntity najdiMistoOdberu(int id) {
        Session session = sessionFactory.openSession();
        OdberneMistoEntity odberneMisto = session.get(OdberneMistoEntity.class, id);
        session.close();
        return odberneMisto;
    }
}
