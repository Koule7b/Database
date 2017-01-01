package Databaze.Logika;

import Databaze.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.annotations.PropertyBinder;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Engine {

    Session session;
    public Engine(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        this.session = sessionFactory.openSession();
    }
    public void vytvorZakaznika(){
        //ZakaznikEntity zakaznikEntity = new ZakaznikEntity();
        //zakaznikEntity.setId(2);
        //zakaznikEntity.setAdresa("Strakonická 17, České Budějovice");
        //zakaznikEntity.setJmeno("Lucie");
        //zakaznikEntity.setPrijmeni("Navrátilová");
        //MereniEntity zakaznikEntity = new MereniEntity();
        /**
        zakaznikEntity.setId(3);
        zakaznikEntity.setDatum("01.01.2017");
        zakaznikEntity.setHodnota(15);
        OdberneMistoEntity odberneMistoEntity = new OdberneMistoEntity();
        odberneMistoEntity.setAdresa("Strakonická 15, České Budějovice");
        odberneMistoEntity.setEan(1);
         */
        //zakaznikEntity.setOdberneMistoByMistoOdberu(odberneMistoEntity);
        //session.beginTransaction();
        //session.save(zakaznikEntity);
        //session.getTransaction().commit();
        //session.close();
        //zakaznikEntity = null;
        //session = sessionFactory.openSession();
        //session.beginTransaction();
        //session.getTransaction().commit();
        //session.close();
        //zakaznikEntity = session.get(MereniEntity.class, 1);
        //System.out.println(zakaznikEntity.getId()+" "+zakaznikEntity.getDatum()+" "+zakaznikEntity.getHodnota()+" "+zakaznikEntity.getOdberneMistoByMistoOdberu());
        //Transaction transaction = session.getTransaction();
        //transaction.begin();
        //transaction.commit();
        //if(transaction.isActive()){
            //transaction.rollback();
        //}
    }
    public void vytvorMistoOdberu(){

    }
    public void vytvorPlatbu(){

    }
    public void vytvorProdukt(){

    }
    public void vytvorMereni(){

    }
    public void vytvormlouvu(){

    }
    public void vypisMereni(){
        ArrayList<MereniEntity> mereniEntities;
        mereniEntities = (ArrayList<MereniEntity>) session.createCriteria(MereniEntity.class).list();
        for (int i = 0; i < mereniEntities.size(); i++) {

        }
    }
    public void vypisOdberneMista(){
        ArrayList<OdberneMistoEntity> odberneMistoEntities;
        odberneMistoEntities = (ArrayList<OdberneMistoEntity>) session.createCriteria(OdberneMistoEntity.class).list();
        for (int i = 0; i < odberneMistoEntities.size(); i++) {

        }
    }
    public void vypisPlatby(){
        ArrayList<PlatbaEntity> platbaEntities;
        platbaEntities = (ArrayList<PlatbaEntity>) session.createCriteria(PlatbaEntity.class).list();
        for (int i = 0; i < platbaEntities.size(); i++) {

        }
    }
    public void vypisProdukty(){
        ArrayList<ProduktyEntity> produktyIntities;
        produktyIntities = (ArrayList<ProduktyEntity>) session.createCriteria(ProduktyEntity.class).list();
        for (int i = 0; i < produktyIntities.size(); i++) {

        }
    }
    public void vypisSmlouvy(){
        ArrayList<SmlouvaEntity> smlouvaEntities;
        smlouvaEntities = (ArrayList<SmlouvaEntity>) session.createCriteria(SmlouvaEntity.class).list();
        for (int i = 0; i < smlouvaEntities.size(); i++) {

        }
    }
    public void vypisZakazniky(Graphics g){
        ArrayList<ZakaznikEntity> zakaznikEntities;
        zakaznikEntities = (ArrayList<ZakaznikEntity>) session.createCriteria(ZakaznikEntity.class).list();
        int mezera = 29;
        for (int i = 0; i < zakaznikEntities.size(); i++) {
            g.drawString(String.valueOf(zakaznikEntities.get(i).getId()), mezera, mezera);
            mezera += mezera;
        }
    }
    // TODO: 30.12.16 vyřešit problém připojeni hibernate a připojení k databázi.
}
