package Databaze.Grafika;

import Databaze.*;
import Databaze.Logika.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

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
    //Tutorial z knihy
    JTable jTable;
    Session session;
    SessionFactory sessionFactory;
    ClassMetadata classMetadata;
    JScrollPane jScrollPane;
    //JToggleButton

    public Aplikace(Okno okno) {
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
        add(vyber, BorderLayout.WEST);
        add(tlacitka, BorderLayout.NORTH);
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        engine = new Engine(session);
        jTable = new JTable();
        jScrollPane = new JScrollPane();
        this.add(jScrollPane);
        this.okno = okno;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String zmacknuteTlacitko = e.getActionCommand();
        switch (zmacknuteTlacitko){
            case novy:
                this.requestFocus(false);
                OknoNovaPlatba oknoNovaPlatba = new OknoNovaPlatba(engine);
                oknoNovaPlatba.vypln();
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        switch (e.getItem().toString()){
            case mer:
                zakaznik.setState(false);
                odberneMisto.setState(false);
                platba.setState(false);
                produkty.setState(false);
                smlouva.setState(false);
                this.remove(jScrollPane);
                classMetadata = sessionFactory.getClassMetadata(MereniEntity.class);
                String[] jmenaM = {classMetadata.getIdentifierPropertyName(), classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1], classMetadata.getPropertyNames()[2]};
                jTable = new JTable(engine.vypisMereni(), jmenaM);
                this.add(jScrollPane = new JScrollPane(jTable));
                this.repaint();
                okno.setVisible(true);
                break;
            case odM:
                mereni.setState(false);
                zakaznik.setState(false);
                platba.setState(false);
                produkty.setState(false);
                smlouva.setState(false);
                this.remove(jScrollPane);
                classMetadata = sessionFactory.getClassMetadata(OdberneMistoEntity.class);
                String[] jmenaO = {classMetadata.getIdentifierPropertyName(), classMetadata.getPropertyNames()[0]};
                jTable = new JTable(engine.vypisMistaOdberu(), jmenaO);
                this.add(jScrollPane = new JScrollPane(jTable));
                this.repaint();
                okno.setVisible(true);
                break;
            case pla:
                mereni.setState(false);
                odberneMisto.setState(false);
                zakaznik.setState(false);
                produkty.setState(false);
                smlouva.setState(false);
                this.remove(jScrollPane);
                classMetadata = sessionFactory.getClassMetadata(PlatbaEntity.class);
                String[] jmenaPla = {classMetadata.getIdentifierPropertyName(), classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1], classMetadata.getPropertyNames()[2]};
                jTable = new JTable(engine.vypisPlatby(), jmenaPla);
                this.add(jScrollPane = new JScrollPane(jTable));
                this.repaint();
                okno.setVisible(true);
                break;
            case pro:
                mereni.setState(false);
                odberneMisto.setState(false);
                platba.setState(false);
                zakaznik.setState(false);
                smlouva.setState(false);
                this.remove(jScrollPane);
                classMetadata = sessionFactory.getClassMetadata(ProduktyEntity.class);
                String[] jmenaPro = {classMetadata.getIdentifierPropertyName(), classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1]};
                jTable = new JTable(engine.vypisProdukty(), jmenaPro);
                this.add(jScrollPane = new JScrollPane(jTable));
                this.repaint();
                okno.setVisible(true);
                break;
            case sml:
                mereni.setState(false);
                odberneMisto.setState(false);
                platba.setState(false);
                produkty.setState(false);
                zakaznik.setState(false);
                this.remove(jScrollPane);
                classMetadata = sessionFactory.getClassMetadata(SmlouvaEntity.class);
                System.out.println(Arrays.toString(classMetadata.getPropertyNames()));
                classMetadata.getIdentifierPropertyName();
                String[] jmenaS = {classMetadata.getIdentifierPropertyName(), classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1], classMetadata.getPropertyNames()[2], classMetadata.getPropertyNames()[3], classMetadata.getPropertyNames()[4]};
                jTable = new JTable(engine.vypisSmlouvy(), jmenaS);
                this.add(jScrollPane = new JScrollPane(jTable));
                this.repaint();
                okno.setVisible(true);
                break;
            case zak:
                mereni.setState(false);
                odberneMisto.setState(false);
                platba.setState(false);
                produkty.setState(false);
                smlouva.setState(false);
                this.remove(jScrollPane);
                classMetadata = sessionFactory.getClassMetadata(ZakaznikEntity.class);
                String[] jmenaZ = {classMetadata.getIdentifierPropertyName(), classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1], classMetadata.getPropertyNames()[2]};
                jTable = new JTable(engine.vypisZakazniky(), jmenaZ);
                this.add(jScrollPane = new JScrollPane(jTable));
                this.repaint();
                okno.setVisible(true);
                break;
        }
    }
}
