package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stepanmudra on 15.01.17.
 */
public class OknoNoveOdberneMisto extends JFrame {
    Engine engine;
    public OknoNoveOdberneMisto(Engine engine) {
        setTitle("Nové místo odběru");
        setDefaultCloseOperation(OknoNovaPlatba.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));
        setResizable(true);
        this.engine = engine;
    }
    public void vypln(){
        VnitrekNMO vnitrekNS = new VnitrekNMO(this, engine);
        vnitrekNS.vyplnOknoN();
        this.setVisible(true);
        this.pack();
    }
}class VnitrekNMO extends JPanel implements ActionListener {
    OknoNoveOdberneMisto oknoNoveOdberneMisto;
    Engine engine;
    JPanel levo;
    JPanel pravo;
    JLabel id;
    JLabel adresa;
    JTextField idT;
    JTextField adresaT;
    JButton ulozit;
    JButton zavrit;
    final String ulo = "uložit";
    final String zav = "zavřít";

    public VnitrekNMO(OknoNoveOdberneMisto oknoNoveOdberneMisto, Engine engine) {
        this.oknoNoveOdberneMisto = oknoNoveOdberneMisto;
        this.engine = engine;
    }

    public void vyplnOknoN() {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        levo = new JPanel();
        levo.setLayout(new BoxLayout(levo, BoxLayout.PAGE_AXIS));
        pravo = new JPanel();
        pravo.setLayout(new BoxLayout(pravo, BoxLayout.PAGE_AXIS));
        id = new JLabel("ean");
        adresa = new JLabel("adresa");
        idT = new JTextField();
        adresaT = new JTextField();
        ulozit = new JButton(ulo);
        zavrit = new JButton(zav);
        ulozit.addActionListener(this);
        zavrit.addActionListener(this);
        levo.add(id);
        levo.add(idT);
        levo.add(ulozit);
        pravo.add(adresa);
        pravo.add(adresaT);
        pravo.add(zavrit);
        this.add(levo);
        this.add(pravo);
        oknoNoveOdberneMisto.add(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ulo:
                engine.vytvorMistoOdberu(Integer.parseInt(idT.getText()), adresaT.getText());
                break;
            case zav:
                oknoNoveOdberneMisto.dispose();
                break;
        }
    }
}
