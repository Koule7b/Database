package Databaze.Grafika.Okna;

import Databaze.Entity.MereniEntity;
import Databaze.Entity.OdberneMistoEntity;
import Databaze.Fasady.MistoOdberu;
import org.hibernate.SessionFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private MereniEntity mereniEntity = null;
    private SessionFactory sessionFactory;

    public OknoMereni(MereniEntity mereniEntity, SessionFactory sessionFactory){
        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
            comboBox1.addItem(odberneMistoEntity.getAdresa());
        }
        comboBox1.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){

        }
    }
}
