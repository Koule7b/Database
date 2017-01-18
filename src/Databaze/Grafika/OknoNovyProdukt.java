package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stepanmudra on 15.01.17.
 */
public class OknoNovyProdukt extends JFrame{
    Engine engine;
    public OknoNovyProdukt(Engine engine) {
        setTitle("Nový produkt");
        setDefaultCloseOperation(OknoNovaPlatba.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        setResizable(true);
        this.engine = engine;
    }
    public void vypln(){
        VnitrekNPro vnitrekNPro = new VnitrekNPro(this, engine);
        vnitrekNPro.vyplnOknoN();
        this.setVisible(true);
        this.pack();
    }
}class VnitrekNPro extends JPanel implements ActionListener {
    OknoNovyProdukt oknoNovyProdukt;
    Engine engine;
    JPanel levo;
    JPanel pravo;
    JLabel id;
    JLabel cena;
    JLabel popis;
    JTextField idT;
    JTextField cenaT;
    JTextField popisT;
    JButton ulozit;
    JButton zavrit;
    final String ulo = "uložit";
    final String zav = "zavřít";

    public VnitrekNPro(OknoNovyProdukt oknoNovyProdukt, Engine engine) {
        this.oknoNovyProdukt = oknoNovyProdukt;
        this.engine = engine;
    }

    public void vyplnOknoN() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        levo = new JPanel();
        levo.setLayout(new BoxLayout(levo, BoxLayout.PAGE_AXIS));
        pravo = new JPanel();
        pravo.setLayout(new BoxLayout(pravo, BoxLayout.PAGE_AXIS));
        id = new JLabel("id");
        cena = new JLabel("cena");
        popis = new JLabel("popis");
        idT = new JTextField();
        cenaT = new JTextField();
        popisT = new JTextField();
        ulozit = new JButton(ulo);
        zavrit = new JButton(zav);
        ulozit.addActionListener(this);
        zavrit.addActionListener(this);
        levo.add(id);
        levo.add(idT);
        levo.add(cena);
        levo.add(cenaT);
        levo.add(ulozit);
        pravo.add(popis);
        pravo.add(popisT);
        pravo.add(zavrit);
        this.add(levo);
        this.add(pravo);
        oknoNovyProdukt.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ulo:
                engine.vytvorProdukt(Integer.parseInt(idT.getText()), Integer.parseInt(cenaT.getText()), popisT.getText());
                oknoNovyProdukt.dispose();
                break;
            case zav:
                oknoNovyProdukt.dispose();
                break;
        }
    }
}
