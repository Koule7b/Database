package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stepanmudra on 15.01.17.
 */
public class OknoNovaPlatba extends JFrame{
    Engine engine;
    public OknoNovaPlatba(Engine engine){
        setTitle("Nová platba");
        setDefaultCloseOperation(OknoNovaPlatba.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 150));
        setResizable(true);
        this.engine = engine;
    }
    public void vypln(){
        VnitrekNP vnitrekNP = new VnitrekNP(this, engine);
        vnitrekNP.vyplnOnkoP();
        this.setVisible(true);
        this.pack();
    }
}
class VnitrekNP extends JPanel implements ActionListener{
    OknoNovaPlatba oknoNovaPlatba;
    Engine engine;
    JPanel popisky;
    JPanel textovaPole;
    JLabel id;
    JLabel datum;
    JLabel castka;
    JLabel idSmlouvy;
    JTextField idP;
    JTextField dat;
    JTextField cas;
    JTextField idS;
    JButton ulozit;
    JButton zavrit;
    String ulo = "uložit";
    String zav = "zavřít";
    public VnitrekNP(OknoNovaPlatba oknoNovaPlatba, Engine engine){
        this.oknoNovaPlatba = oknoNovaPlatba;
        this.engine = engine;
    }
    public void vyplnOnkoP(){
        ulozit = new JButton(ulo);
        ulozit.addActionListener(this);
        zavrit = new JButton(zav);
        zavrit.addActionListener(this);
        id = new JLabel("id");
        datum = new JLabel("datum");
        castka = new JLabel("částka");
        idSmlouvy = new JLabel("id smlouvy");
        idP = new JTextField();
        dat = new JTextField();
        cas = new JTextField();
        idS = new JTextField();
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        popisky = new JPanel();
        popisky.setLayout(new BoxLayout(popisky, BoxLayout.PAGE_AXIS));
        popisky.add(id);
        popisky.add(idP);
        popisky.add(castka);
        popisky.add(cas);
        popisky.add(ulozit);
        this.add(popisky);
        textovaPole = new JPanel();
        textovaPole.setLayout(new BoxLayout(textovaPole, BoxLayout.PAGE_AXIS));
        textovaPole.add(datum);
        textovaPole.add(dat);
        textovaPole.add(idSmlouvy);
        textovaPole.add(idS);
        textovaPole.add(zavrit);
        this.add(textovaPole);
        oknoNovaPlatba.add(this);
        this.requestFocus(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String zmacknuto = e.getActionCommand();
        switch (zmacknuto){
            case "uložit":
                engine.vytvorPlatbu(Integer.parseInt(idP.getText()), dat.getText(),Integer.parseInt(cas.getText()), Integer.parseInt(idS.getText()));
                oknoNovaPlatba.dispose();
                break;
            case "zavřít":
                oknoNovaPlatba.dispose();
                break;
        }
    }
}
