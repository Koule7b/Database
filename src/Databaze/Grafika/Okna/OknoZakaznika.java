package Databaze.Grafika.Okna;

import org.hibernate.SessionFactory;

import javax.swing.*;

/**
 * Created by stepanmudra on 28.01.17.
 */
public class OknoZakaznika {
    private JButton uložitButton;
    private JButton zrušitButton;
    private JFormattedTextField formattedTextField1;
    private JTextField textField1;
    private JTextField textField2;
    private JFormattedTextField formattedTextField2;
    private SessionFactory sessionFactory;

    public OknoZakaznika(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
