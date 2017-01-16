package Databaze.Grafika;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stepanmudra on 16.01.17.
 */
public class OknoChyby extends JFrame{
    public OknoChyby() {
        setTitle("Chyba");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(300, 300));
        setResizable(false);
    }
    public void vypisChybu(){
        ChybkaID chybkaID = new ChybkaID(this);
        chybkaID.vypln();
        this.pack();
        this.setVisible(true);
    }
}class ChybkaID extends JPanel{
    OknoChyby oknoChyby;
    public ChybkaID(OknoChyby oknoChyby) {
        this.oknoChyby = oknoChyby;
    }
    public void vypln(){
        this.add(new JLabel("Toto id již existuje"));
        oknoChyby.add(this);
    }
}
