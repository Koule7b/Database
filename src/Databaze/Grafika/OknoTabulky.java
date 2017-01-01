package Databaze.Grafika;

import Databaze.Logika.Engine;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stepanmudra on 01.01.17.
 */
public class OknoTabulky extends JScrollPane{
    Engine engine;
    int vykresleni;
    public OknoTabulky(Engine engine, int vykresleni){
        this.engine = engine;
        this.vykresleni = vykresleni;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        switch (vykresleni){
            case 1:
                engine.vypisZakazniky(g);
                break;
            case 2:
                engine.vypisZakazniky(g);
                break;
            case 3:
                engine.vypisZakazniky(g);
                break;
            case 4:
                engine.vypisZakazniky(g);
                break;
            case 5:
                engine.vypisZakazniky(g);
                break;
            case 6:
                engine.vypisZakazniky(g);
                break;
        }
    }
}
