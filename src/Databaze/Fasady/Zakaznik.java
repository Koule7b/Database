package Databaze.Fasady;

import Databaze.Entity.ZakaznikEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by stepanmudra on 20.01.17.
 */
public class Zakaznik {
    SessionFactory sessionFactory;

    public Zakaznik(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void novyZakaznik(int id,String jmeno, String prijmeni, String adresa){
        ZakaznikEntity zakaznik = new ZakaznikEntity();
        zakaznik.setId(id);
        zakaznik.setJmeno(jmeno);
        zakaznik.setPrijmeni(prijmeni);
        zakaznik.setAdresa(adresa);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(zakaznik);
        session.close();
    }

    public void zmenZakaznika(ZakaznikEntity zakaznik, String adresa, int id,String jmeno, String prijmeni){
        zakaznik.setId(id);
        zakaznik.setJmeno(jmeno);
        zakaznik.setPrijmeni(prijmeni);
        zakaznik.setAdresa(adresa);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(zakaznik);
        session.close();
    }

    public ZakaznikEntity najdiZakaznika(int id){
        Session session = sessionFactory.openSession();
        ZakaznikEntity zakaznik = session.get(ZakaznikEntity.class, id);
        session.close();
        return zakaznik;
    }

    public List<ZakaznikEntity> getSeznamZakazniku(){
        Session session = sessionFactory.openSession();
        List<ZakaznikEntity> seznamZakazniku = session.createCriteria(ZakaznikEntity.class).list();
        session.close();
        return seznamZakazniku;
    }
}
