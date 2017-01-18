package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stepanmudra on 15.01.17.
 */
public class OknoZmenyZakaznika extends JFrame {
    Engine engine;
    public OknoZmenyZakaznika(Engine engine) {
        setTitle("Změna zákazníka");
        setDefaultCloseOperation(OknoNovaPlatba.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        setResizable(true);
        this.engine = engine;
    }
    public void vypln(){
        VnitrekZZ vnitrekNZ = new VnitrekZZ(this, engine);
        vnitrekNZ.vyplnOknoNZ();
        this.setVisible(true);
        this.pack();
    }
}class VnitrekZZ extends JPanel implements ActionListener {
    OknoZmenyZakaznika oknoNovyZakaznik;
    Engine engine;
    JPanel levo;
    JPanel pravo;
    JComboBox id;
    JLabel jmeno;
    JLabel prijmeni;
    JLabel adresa;
    JTextField idT;
    JTextField jmenoT;
    JTextField prijmeniT;
    JTextField adresaT;
    JButton ulozit;
    JButton zavrit;
    Object[][] zak;
    final String  ulo = "uložit";
    final String zav = "zavřít";
    public VnitrekZZ(OknoZmenyZakaznika oknoNovyZakaznik, Engine engine){
        this.oknoNovyZakaznik= oknoNovyZakaznik;
        this.engine = engine;
    }
    public void vyplnOknoNZ(){
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        levo = new JPanel();
        levo.setLayout(new BoxLayout(levo, BoxLayout.PAGE_AXIS));
        pravo = new JPanel();
        pravo.setLayout(new BoxLayout(pravo, BoxLayout.PAGE_AXIS));
        id = new JComboBox();
        jmeno = new JLabel("jméno");
        prijmeni = new JLabel("přijmení");
        adresa = new JLabel("adresa");
        jmenoT = new JTextField();
        prijmeniT = new JTextField();
        adresaT = new JTextField();
        zak = engine.vypisZakazniky();
        for (int i = 0; i < zak.length; i++) {
            id.addItem(zak[i][0]);
        }
        id.addActionListener(this);
        ulozit = new JButton(ulo);
        zavrit = new JButton(zav);
        ulozit.addActionListener(this);
        zavrit.addActionListener(this);
        levo.add(id);
        levo.add(jmeno);
        levo.add(jmenoT);
        levo.add(ulozit);
        pravo.add(prijmeni);
        pravo.add(prijmeniT);
        pravo.add(adresa);
        pravo.add(adresaT);
        pravo.add(zavrit);
        this.add(levo);
        this.add(pravo);
        oknoNovyZakaznik.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ulo:
                engine.zmenZakaznika(id.getSelectedIndex() + 1, jmenoT.getText(), prijmeniT.getText(), adresaT.getText());
                oknoNovyZakaznik.dispose();
                break;
            case zav:
                oknoNovyZakaznik.dispose();
                break;
        }
        jmenoT.setText(zak[id.getSelectedIndex()][2].toString());
        prijmeniT.setText(zak[id.getSelectedIndex()][3].toString());
        adresaT.setText(zak[id.getSelectedIndex()][1].toString());
    }
}
