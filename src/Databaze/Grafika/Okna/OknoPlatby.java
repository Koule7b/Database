package Databaze.Grafika.Okna;

import Databaze.Entity.PlatbaEntity;
import org.hibernate.SessionFactory;

import javax.swing.*;

/**
 * Created by stepanmudra on 28.01.17.
 */
public class OknoPlatby {
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField2;
    private PlatbaEntity platba;
    private SessionFactory sessionFactory;

    public OknoPlatby (PlatbaEntity platba, SessionFactory sessionFactory){
        this.platba = platba;
        this.sessionFactory = sessionFactory;
    }
    public OknoPlatby(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
}
