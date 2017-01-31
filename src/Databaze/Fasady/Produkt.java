package Databaze.Fasady;

import Databaze.Entity.ProduktyEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by stepanmudra on 20.01.17.
 */
public class Produkt {
    SessionFactory sessionFactory;

    public Produkt(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void novyProdukt(String popis, int cena){
        ProduktyEntity produkt = new ProduktyEntity();
        produkt.setCena(cena);
        produkt.setPopis(popis);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(produkt);
        session.close();
    }

    public void zmenProdukt(ProduktyEntity produkt, int cena, String popis){
        produkt.setCena(cena);
        produkt.setPopis(popis);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(produkt);
        session.close();
    }

    public void smazProdukt(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.remove(session.load(ProduktyEntity.class, id));
        session.getTransaction().commit();
        session.close();
    }

    public ProduktyEntity najdiProdukt(int id){
        Session session = sessionFactory.openSession();
        ProduktyEntity produkt = session.get(ProduktyEntity.class, id);
        session.close();
        return produkt;
    }

    public List<ProduktyEntity> getSeznamProduktu(){
        Session session = sessionFactory.openSession();
        List<ProduktyEntity> seznamProduktu = session.createCriteria(ProduktyEntity.class).list();
        session.close();
        return seznamProduktu;
    }
}
