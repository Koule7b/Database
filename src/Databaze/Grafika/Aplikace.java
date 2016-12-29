package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Aplikace extends JPanel implements ActionListener, ItemListener {

    private JFrame okno;
    private final String novy = "nový";
    private final String s = "smazat";
    private final String zmeni = "změnit";
    private final String mer = "měření";
    private final String odM = "odběrné místo";
    private final String pla = "platba";
    private final String pro = "produkt";
    private final String sml = "smlouva";
    private final String zak = "zákazník";
    private JButton pridat = new JButton(novy);
    private JButton smazat = new JButton(s);
    private JButton zmenit = new JButton(zmeni);
    private Checkbox mereni = new Checkbox(mer);
    private Checkbox odberneMisto = new Checkbox(odM);
    private Checkbox platba = new Checkbox(pla);
    private Checkbox produkty = new Checkbox(pro);
    private Checkbox smlouva = new Checkbox(sml);
    private Checkbox zakaznik = new Checkbox(zak);
    private Engine engine;

    public Aplikace(Okno okno){
        setLayout(new BorderLayout());
        JPanel vyber = new JPanel();
        vyber.setLayout(new BoxLayout(vyber, BoxLayout.Y_AXIS));
        mereni.addItemListener(this);
        odberneMisto.addItemListener(this);
        platba.addItemListener(this);
        produkty.addItemListener(this);
        smlouva.addItemListener(this);
        zakaznik.addItemListener(this);
        vyber.add(mereni);
        vyber.add(odberneMisto);
        vyber.add(platba);
        vyber.add(produkty);
        vyber.add(smlouva);
        vyber.add(zakaznik);
        JPanel tlacitka = new JPanel();
        tlacitka.setLayout(new FlowLayout());
        pridat.addActionListener(this);
        smazat.addActionListener(this);
        zmenit.addActionListener(this);
        tlacitka.add(pridat);
        tlacitka.add(smazat);
        tlacitka.add(zmenit);
        engine = new Engine();
        add(vyber, BorderLayout.WEST);
        add(tlacitka, BorderLayout.NORTH);
        this.okno = okno;
    }
    public void zobrazData(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String zmacknuteTlacitko = e.getActionCommand();
        switch (zmacknuteTlacitko){
            case novy:
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
