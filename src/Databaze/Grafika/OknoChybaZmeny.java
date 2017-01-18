package Databaze.Grafika;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stepanmudra on 17.01.17.
 */
public class OknoChybaZmeny extends JFrame{
    public OknoChybaZmeny() {
        setTitle("Chyba");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 100));
        setResizable(false);
    }
    public void vypisChybu(){
        ChybaZmeny chybkaID = new ChybaZmeny(this);
        chybkaID.vypln();
        this.pack();
        this.setVisible(true);
    }
}class ChybaZmeny extends JPanel{
    OknoChybaZmeny oknoChyby;
    public ChybaZmeny(OknoChybaZmeny oknoChyby) {
        this.oknoChyby = oknoChyby;
    }
    public void vypln() {
        this.add(new JLabel("Tuto položku nelze upravovat"));
        oknoChyby.add(this);
    }
}
