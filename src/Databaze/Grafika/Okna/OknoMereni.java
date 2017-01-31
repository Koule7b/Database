package Databaze.Grafika.Okna;

import Databaze.Entity.MereniEntity;
import Databaze.Entity.OdberneMistoEntity;
import Databaze.Fasady.Mereni;
import Databaze.Fasady.MistoOdberu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by stepanmudra on 28.01.17.
 */
public class OknoMereni extends JFrame implements ActionListener {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel;
    private JButton uložitButton;
    private JButton zrušitButton;
    private MereniEntity mereniEntity;
    private SessionFactory sessionFactory;

    public OknoMereni(int id, SessionFactory sessionFactory){
        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Session session =  sessionFactory.openSession();
        this.mereniEntity = mereniEntity;
        this.sessionFactory = sessionFactory;
        textField1.setText(mereniEntity.getDatum());
        textField2.setText(String.valueOf(mereniEntity.getHodnota()));
        MistoOdberu mistoOdberu = new MistoOdberu(sessionFactory);
        for (OdberneMistoEntity odberneMistoEntity : mistoOdberu.vypisMistaOdberu()) {
            comboBox1.addItem(odberneMistoEntity.getAdresa());
        }
        comboBox1.addActionListener(this);
        comboBox1.setSelectedItem(mereniEntity.getOdberneMistoByMistoOdberu().getAdresa());
        pack();
        setVisible(true);
    }

    public OknoMereni(SessionFactory sessionFactory) {
        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.sessionFactory = sessionFactory;
        MistoOdberu mistoOdberu = new MistoOdberu(sessionFactory);
        List<OdberneMistoEntity> seznamMist = mistoOdberu.vypisMistaOdberu();
        for (OdberneMistoEntity odberneMistoEntity : mistoOdberu.vypisMistaOdberu()) {
            comboBox1.addItem(odberneMistoEntity);
        }
        comboBox1.addActionListener(this);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Uložit":
                        Mereni mereni = new Mereni(sessionFactory);
                        System.out.println(comboBox1.getSelectedIndex());
                        MistoOdberu mistoOdberu = new MistoOdberu(sessionFactory);
                        //System.out.println(Date.parse(textField1.getText()));
                        try {
                            DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
                            Date datum = dateFormat.parse(textField1.getText());
                        }catch (IllegalArgumentException exc){
                            PrazdneKolonky prazdneKolonky  = new PrazdneKolonky();
                        } catch (ParseException e1) {
                            PrazdneKolonky prazdneKolonky  = new PrazdneKolonky();
                        }
                        if(textField1.getText().equals("")) {
                            PrazdneKolonky prazdneKolonky = new PrazdneKolonky();
                            prazdneKolonky.main();
                        }else {
                            mereni.noveMereni(textField1.getText(), Integer.valueOf(textField2.getText()), mistoOdberu.najdiMistoOdberu(comboBox1.getSelectedIndex() + 1));
                            dispose();
                        }
                        break;
                    case "Zrušit":
                        dispose();
                }
            }
        };
        uložitButton.addActionListener(actionListener);
        zrušitButton.addActionListener(actionListener);
        pack();
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
