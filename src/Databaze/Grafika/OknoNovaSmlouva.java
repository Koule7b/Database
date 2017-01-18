package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stepanmudra on 15.01.17.
 */
public class OknoNovaSmlouva extends JFrame{
    Engine engine;
    public OknoNovaSmlouva(Engine engine){
        setTitle("Nová smlouva");
        setDefaultCloseOperation(OknoNovaPlatba.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        setResizable(true);
        this.engine = engine;
    }
    public void vypln(){
        VnitrekNS vnitrekNS = new VnitrekNS(this, engine);
        vnitrekNS.vyplnOknoS();
        this.setVisible(true);
        this.pack();
    }
}
class VnitrekNS extends JPanel implements ActionListener{
    Engine engine;
    OknoNovaSmlouva oknoNovaSmlouva;
    JPanel levo;
    JPanel pravo;
    JLabel id;
    JLabel datumP;
    JLabel datumU;
    JLabel idZ;
    JLabel idP;
    JLabel idMO;
    JTextField idT;
    JTextField datumPT;
    JTextField datumUT;
    JComboBox idZT;
    JComboBox idPT;
    JComboBox idMOT;
    JButton ulozit;
    JButton zavrit;
    final String ulo = "uložit";
    final String zav = "zavřít";
    public VnitrekNS(OknoNovaSmlouva oknoNovaSmlouva, Engine engine) {
        this.engine = engine;
        this.oknoNovaSmlouva = oknoNovaSmlouva;
    }
    public void vyplnOknoS(){
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        ulozit = new JButton(ulo);
        ulozit.addActionListener(this);
        zavrit = new JButton(zav);
        zavrit.addActionListener(this);
        id = new JLabel("id");
        datumP = new JLabel("datum uzavření smlouvy");
        datumU = new JLabel("datum vypršení smlouvy");
        idZ = new JLabel("id zákazníka");
        idP = new JLabel("id produktu");
        idMO = new JLabel("id místa odběru");
        idT = new JTextField();
        datumPT = new JTextField();
        datumUT = new JTextField();
        idZT = new JComboBox();
        Object[][] zak = engine.vypisZakazniky();
        for (int i = 0; i < zak.length; i++) {
            idZT.addItem(zak[i][0]);
        }
        idPT = new JComboBox();
        Object[][] pro = engine.vypisProdukty();
        for (int i = 0; i < pro.length; i++) {
            idPT.addItem(pro[i][0]);
        }
        idMOT = new JComboBox();
        Object[][] misOd = engine.vypisMistaOdberu();
        for (int i = 0; i < misOd.length; i++) {
            idMOT.addItem(misOd[i][0]);
        }
        levo = new JPanel();
        levo.setLayout(new BoxLayout(levo, BoxLayout.PAGE_AXIS));
        levo.add(id);
        levo.add(idT);
        levo.add(datumP);
        levo.add(datumPT);
        levo.add(datumU);
        levo.add(datumUT);
        levo.add(ulozit);
        pravo = new JPanel();
        pravo.setLayout(new BoxLayout(pravo, BoxLayout.PAGE_AXIS));
        pravo.add(idZ);
        pravo.add(idZT);
        pravo.add(idP);
        pravo.add(idPT);
        pravo.add(idMO);
        pravo.add(idMOT);
        pravo.add(zavrit);
        this.add(levo);
        this.add(pravo);
        oknoNovaSmlouva.add(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case ulo:
                engine.vytvorSmlouvu(Integer.parseInt(idT.getText()), datumPT.getText(), datumUT.getText(), idZT.getSelectedIndex() + 1, idPT.getSelectedIndex() + 1, idMOT.getSelectedIndex() + 1);
                oknoNovaSmlouva.dispose();
                break;
            case zav:
                oknoNovaSmlouva.dispose();
                break;
        }
    }
}
