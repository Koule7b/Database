package Databaze.Grafika.Okna;

import org.hibernate.SessionFactory;

import javax.swing.*;

/**
 * Created by stepanmudra on 28.01.17.
 */
public class OknoProduktu {
    private JButton uložitButton;
    private JButton zrušitButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private SessionFactory sessionFactory;

    public OknoProduktu(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
