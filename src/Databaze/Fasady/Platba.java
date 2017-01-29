package Databaze.Fasady;

import Databaze.Entity.PlatbaEntity;
import Databaze.Entity.SmlouvaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by stepanmudra on 20.01.17.
 */
public class Platba {
    SessionFactory sessionFactory;

    public Platba(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void novaPlatba(String datum, int castka, SmlouvaEntity smlouvaEntity){
        PlatbaEntity platba = new PlatbaEntity();
        platba.setDatum(datum);
        platba.setCastka(castka);
        platba.setSmlouvaByIdSmlovy(smlouvaEntity);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(platba);
        session.close();
    }

    public void zmenPlatbu(PlatbaEntity platba, String datum, int castka, SmlouvaEntity smlouvaEntity){
        platba.setDatum(datum);
        platba.setCastka(castka);
        platba.setSmlouvaByIdSmlovy(smlouvaEntity);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(platba);
        session.close();
    }

    public List<PlatbaEntity> getSeznamPlateb(){
        Session session = sessionFactory.openSession();
        List<PlatbaEntity> seznamPlateb = session.createCriteria(PlatbaEntity.class).list();
        session.close();
        return seznamPlateb;
    }

    public PlatbaEntity najdiPlatbu(int id){
        Session session = sessionFactory.openSession();
        PlatbaEntity platba = session.get(PlatbaEntity.class, id);
        session.close();
        return platba;
    }
}
