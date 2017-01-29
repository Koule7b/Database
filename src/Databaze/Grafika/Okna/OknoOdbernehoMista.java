package Databaze.Grafika.Okna;

import Databaze.Entity.OdberneMistoEntity;
import org.hibernate.SessionFactory;

import javax.swing.*;

/**
 * Created by stepanmudra on 28.01.17.
 */
public class OknoOdbernehoMista extends JFrame{
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private OdberneMistoEntity odberneMisto;
    private SessionFactory sessionFactory;

    public OknoOdbernehoMista(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

    }

    public OknoOdbernehoMista(OdberneMistoEntity odberneMisto, SessionFactory sessionFactory){
        this.odberneMisto = odberneMisto;
        this.sessionFactory = sessionFactory;
    }
}
