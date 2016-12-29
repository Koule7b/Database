package Databaze.Grafika;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stepanmudra on 29.12.16.
 */
public class Okno extends JFrame {


    private Aplikace aplikace;

    public Okno(){
        setTitle("Databáze zákazníků elektrárny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 700));
        setResizable(false);
        otevriAplikaci();
    }
    public void otevriAplikaci(){
        aplikace = new Aplikace(this);
        this.add(aplikace);
        pack();
        this.setVisible(true);
    }
}
