package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stepanmudra on 15.01.17.
 */
public class OknoNoveMereni extends JFrame{
    Engine engine;
    public OknoNoveMereni(Engine engine) {
        setTitle("Nové měření");
        setDefaultCloseOperation(OknoNovaPlatba.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        setResizable(true);
        this.engine = engine;
    }
    public void vypln(){
        VnitrekNM vnitrekNS = new VnitrekNM(this, engine);
        vnitrekNS.vyplnOknoN();
        this.setVisible(true);
        this.pack();
    }
}class VnitrekNM extends JPanel implements ActionListener{
    OknoNoveMereni oknoNoveMereni;
    Engine engine;
    JPanel levo;
    JPanel pravo;
    JLabel id;
    JLabel datum;
    JLabel hodnota;
    JLabel mistoOdberu;
    JTextField idT;
    JTextField datumT;
    JTextField hodnotaT;
    JTextField mistoOdberuT;
    JButton ulozit;
    JButton zavrit;
    final String  ulo = "uložit";
    final String zav = "zavřít";
    public VnitrekNM(OknoNoveMereni oknoNoveMereni, Engine engine){
        this.oknoNoveMereni = oknoNoveMereni;
        this.engine = engine;
    }
    public void vyplnOknoN(){
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        levo = new JPanel();
        levo.setLayout(new BoxLayout(levo, BoxLayout.PAGE_AXIS));
        pravo = new JPanel();
        pravo.setLayout(new BoxLayout(pravo, BoxLayout.PAGE_AXIS));
        id = new JLabel("id");
        datum = new JLabel("adresa");
        hodnota = new JLabel("hodnota");
        mistoOdberu = new JLabel("odběrné místo");
        idT = new JTextField();
        datumT = new JTextField();
        hodnotaT = new JTextField();
        mistoOdberuT = new JTextField();
        ulozit = new JButton(ulo);
        zavrit = new JButton(zav);
        ulozit.addActionListener(this);
        zavrit.addActionListener(this);
        levo.add(id);
        levo.add(idT);
        levo.add(datum);
        levo.add(datumT);
        levo.add(ulozit);
        pravo.add(hodnota);
        pravo.add(hodnotaT);
        pravo.add(mistoOdberu);
        pravo.add(mistoOdberuT);
        pravo.add(zavrit);
        this.add(levo);
        this.add(pravo);
        oknoNoveMereni.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ulo:
                engine.vytvorMereni(Integer.parseInt(idT.getText()), datumT.getText(), Integer.parseInt(hodnotaT.getText()), Integer.parseInt(mistoOdberuT.getText()));
                break;
            case zav:
                oknoNoveMereni.dispose();
                break;
        }
    }
}
