package Databaze.Grafika.Okna;

import Databaze.Entity.*;
import Databaze.Fasady.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by stepanmudra on 27.01.17.
 */
public class OknoAplikace extends JFrame {
    private JTabbedPane tabbedPane1;
    private JButton změnitButton;
    private JButton smazatButton;
    private JPanel panel;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JTable table6;
    private JPanel puvodniPanel;
    private JButton novy;

    public OknoAplikace() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(puvodniPanel);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        vypisMereni(sessionFactory);
        tabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                switch (tabbedPane1.getSelectedIndex()) {
                    case 0:
                        vypisMereni(sessionFactory);
                        break;
                    case 1:
                        vypisOdbernaMista(sessionFactory);
                        break;
                    case 2:
                        vypisPlatby(sessionFactory);
                        break;
                    case 3:
                        vypisProdukty(sessionFactory);
                        break;
                    case 4:
                        vypisSmlouvy(sessionFactory);
                        break;
                    case 5:
                        vypisZakazniky(sessionFactory);
                        break;
                }
            }
        });
        pack();
        setVisible(true);
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pocetMacknuti = e.getClickCount();
                if (pocetMacknuti == 1) {//SwingUtilities.isRightMouseButton(e)){
                    Mereni mereni = new Mereni(sessionFactory);
                    //System.out.println(table1.getSelectedRow());
                    OknoMereni oknoMereni = new OknoMereni(mereni.najdiMereni(table1.getSelectedRow() + 1), sessionFactory);
                }
            }
        });
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pocetMacknuti = e.getClickCount();
                if (pocetMacknuti == 1) {//SwingUtilities.isRightMouseButton(e)){
                    MistoOdberu mistoOdberu = new MistoOdberu(sessionFactory);
                    //System.out.println(table1.getSelectedRow());
                    OknoOdbernehoMista oknoOdbernehoMista = new OknoOdbernehoMista(mistoOdberu.najdiMistoOdberu(table1.getSelectedRow() + 1), sessionFactory);
                }
            }
        });
        table3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pocetMacknuti = e.getClickCount();
                if (pocetMacknuti == 1) {//SwingUtilities.isRightMouseButton(e)){
                    Mereni mereni = new Mereni(sessionFactory);
                    //System.out.println(table1.getSelectedRow());
                    OknoMereni oknoMereni = new OknoMereni(mereni.najdiMereni(table1.getSelectedRow() + 1), sessionFactory);
                }
            }
        });
        table4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pocetMacknuti = e.getClickCount();
                if (pocetMacknuti == 1) {//SwingUtilities.isRightMouseButton(e)){
                    Mereni mereni = new Mereni(sessionFactory);
                    //System.out.println(table1.getSelectedRow());
                    OknoMereni oknoMereni = new OknoMereni(mereni.najdiMereni(table1.getSelectedRow() + 1), sessionFactory);
                }
            }
        });
        table5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pocetMacknuti = e.getClickCount();
                if (pocetMacknuti == 1) {//SwingUtilities.isRightMouseButton(e)){
                    Mereni mereni = new Mereni(sessionFactory);
                    //System.out.println(table1.getSelectedRow());
                    OknoMereni oknoMereni = new OknoMereni(mereni.najdiMereni(table1.getSelectedRow() + 1), sessionFactory);
                }
            }
        });
        table6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int pocetMacknuti = e.getClickCount();
                if (pocetMacknuti == 1) {//SwingUtilities.isRightMouseButton(e)){
                    Mereni mereni = new Mereni(sessionFactory);
                    //System.out.println(table1.getSelectedRow());
                    OknoMereni oknoMereni = new OknoMereni(mereni.najdiMereni(table1.getSelectedRow() + 1), sessionFactory);
                }
            }
        });
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prikaz = e.getActionCommand();
                System.out.println(prikaz);
                switch (prikaz) {
                    case "Změnit":
                        break;
                    case "Nový":
                        switch (tabbedPane1.getSelectedIndex()) {
                            case 0:
                                OknoMereni oknoMereni = new OknoMereni(sessionFactory);
                                break;
                        }
                        break;
                    case "Smazat":
                        break;
                }
            }
        };
        novy.addActionListener(actionListener);
        změnitButton.addActionListener(actionListener);
    }

    private void vypisZakazniky(SessionFactory sessionFactory) {
        Zakaznik zakaznik = new Zakaznik(sessionFactory);
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(ZakaznikEntity.class);
        String[] nazvySloupcu = {"Rodné číslo", classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1], classMetadata.getPropertyNames()[2]};
        for (int i = 0; i < nazvySloupcu.length; i++) {
            System.out.println(nazvySloupcu[i]);
        }

        DefaultTableModel zakaznikModel = new DefaultTableModel();
        zakaznikModel.setColumnIdentifiers(nazvySloupcu);
        table6.setModel(zakaznikModel);

        for (ZakaznikEntity zakaznikEntity : zakaznik.getSeznamZakazniku()) {
            zakaznikModel.addRow(new Object[]{
                    zakaznikEntity.getId(),
                    zakaznikEntity.getJmeno(),
                    zakaznikEntity.getPrijmeni(),
                    zakaznikEntity.getAdresa()
            });
        }
    }

    private void vypisProdukty(SessionFactory sessionFactory) {
        Produkt produkt = new Produkt(sessionFactory);
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(ProduktyEntity.class);
        String[] nazvySloupcu = new String[classMetadata.getPropertyNames().length];
        for (int i = 0; i < nazvySloupcu.length; i++) {
            nazvySloupcu[i] = classMetadata.getPropertyNames()[i];
        }

        DefaultTableModel produktyModel = new DefaultTableModel();
        produktyModel.setColumnIdentifiers(nazvySloupcu);
        table4.setModel(produktyModel);

        for (ProduktyEntity produktyEntity : produkt.getSeznamProduktu()) {
            produktyModel.addRow(new Object[]{
                    produktyEntity.getCena(),
                    produktyEntity.getPopis()
            });
        }
    }

    private void vypisPlatby(SessionFactory sessionFactory) {
        Platba platba = new Platba(sessionFactory);
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(PlatbaEntity.class);
        String[] nazvySloupcu = new String[classMetadata.getPropertyNames().length];
        for (int i = 0; i < nazvySloupcu.length; i++) {
            nazvySloupcu[i] = classMetadata.getPropertyNames()[i];
        }

        DefaultTableModel platbyModel = new DefaultTableModel();
        platbyModel.setColumnIdentifiers(nazvySloupcu);
        table3.setModel(platbyModel);

        for (PlatbaEntity platbaEntity : platba.getSeznamPlateb()) {
            platbyModel.addRow(new Object[]{
                    platbaEntity.getDatum(),
                    platbaEntity.getCastka(),
                    platbaEntity.getSmlouvaByIdSmlovy().getId()
            });
        }
    }

    private void vypisOdbernaMista(SessionFactory sessionFactory) {
        MistoOdberu misto = new MistoOdberu(sessionFactory);
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(OdberneMistoEntity.class);
        String[] nazvySloupcu = {classMetadata.getPropertyNames()[0]};

        DefaultTableModel mistoModel = new DefaultTableModel();
        mistoModel.setColumnIdentifiers(nazvySloupcu);
        table2.setModel(mistoModel);

        for (OdberneMistoEntity odberneMistoEntity : misto.vypisMistaOdberu()) {
            mistoModel.addRow(new Object[]{
                    odberneMistoEntity.getAdresa()
            });
        }
    }

    private void vypisMereni(SessionFactory sessionFactory){
        Mereni mereni = new Mereni(sessionFactory);
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(MereniEntity.class);
        String[] nazvySloupcu = {classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1], "Místo odběru"};

        DefaultTableModel mereniModel = new DefaultTableModel();
        mereniModel.setColumnIdentifiers(nazvySloupcu);
        table1.setModel(mereniModel);


        for (MereniEntity mereniEntity : mereni.getSeznamMereni()) {
            mereniModel.addRow(new Object[]{
                    mereniEntity.getDatum(),
                    mereniEntity.getHodnota(),
                    mereniEntity.getOdberneMistoByMistoOdberu().getAdresa()
            });
        }
    }

    private void vypisSmlouvy(SessionFactory sessionFactory){
        ClassMetadata classMetadata;
        Smlouva smlouva = new Smlouva(sessionFactory);
        classMetadata = sessionFactory.getClassMetadata(SmlouvaEntity.class);
        String[] nazvySloupcu = {classMetadata.getPropertyNames()[0], classMetadata.getPropertyNames()[1], classMetadata.getPropertyNames()[2], classMetadata.getPropertyNames()[3], classMetadata.getPropertyNames()[4]};

        DefaultTableModel smlouvyModel = new DefaultTableModel();
        smlouvyModel.setColumnIdentifiers(nazvySloupcu);

        for (SmlouvaEntity smlouvaEntity : smlouva.getSeznamSmluv()) {
            smlouvyModel.addRow(new Object[]{
                    smlouvaEntity.getDatumPocatku(),
                    smlouvaEntity.getDatumVyprseni(),
                    smlouvaEntity.getZakaznikByIdZakaznika().getPrijmeni(),
                    smlouvaEntity.getProduktyByIdProduktu().getPopis(),
                    smlouvaEntity.getOdberneMistoByIdMistaOdberu().getAdresa()
            });
        }
        table5.setModel(smlouvyModel);
    }
}
