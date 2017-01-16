package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stepanmudra on 15.01.17.
 */
public class OknoNovyZakaznik extends JFrame {
    Engine engine;
    public OknoNovyZakaznik(Engine engine) {
        setTitle("Nové měření");
        setDefaultCloseOperation(OknoNovaPlatba.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        setResizable(true);
        this.engine = engine;
    }
    public void vypln(){
        VnitrekNZ vnitrekNZ = new VnitrekNZ(this, engine);
        vnitrekNZ.vyplnOknoNZ();
        this.setVisible(true);
        this.pack();
    }
}class VnitrekNZ extends JPanel implements ActionListener {
    OknoNovyZakaznik oknoNovyZakaznik;
    Engine engine;
    JPanel levo;
    JPanel pravo;
    JLabel id;
    JLabel jmeno;
    JLabel prijmeni;
    JLabel adresa;
    JTextField idT;
    JTextField jmenoT;
    JTextField prijmeniT;
    JTextField adresaT;
    JButton ulozit;
    JButton zavrit;
    final String  ulo = "uložit";
    final String zav = "zavřít";
    public VnitrekNZ(OknoNovyZakaznik oknoNovyZakaznik, Engine engine){
        this.oknoNovyZakaznik= oknoNovyZakaznik;
        this.engine = engine;
    }
    public void vyplnOknoNZ(){
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        levo = new JPanel();
        levo.setLayout(new BoxLayout(levo, BoxLayout.PAGE_AXIS));
        pravo = new JPanel();
        pravo.setLayout(new BoxLayout(pravo, BoxLayout.PAGE_AXIS));
        id = new JLabel("id");
        jmeno = new JLabel("jméno");
        prijmeni = new JLabel("přijmení");
        adresa = new JLabel("adresa");
        idT = new JTextField();
        jmenoT = new JTextField();
        prijmeniT = new JTextField();
        adresaT = new JTextField();
        ulozit = new JButton(ulo);
        zavrit = new JButton(zav);
        ulozit.addActionListener(this);
        zavrit.addActionListener(this);
        levo.add(id);
        levo.add(idT);
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
                engine.vytvorZakaznika(Integer.parseInt(idT.getText()), jmenoT.getText(), prijmeniT.getText(), adresaT.getText());
                break;
            case zav:
                oknoNovyZakaznik.dispose();
                break;
        }
    }
}
