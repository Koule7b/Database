package Databaze.Grafika.Okna;

import Databaze.Entity.*;
import Databaze.Fasady.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private JTable tabulkaSmluv;

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
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String prikaz = e.getActionCommand();
                System.out.println(prikaz);
                switch (prikaz) {
                    case "Změnit":
                        switch (tabbedPane1.getSelectedIndex()) {
                            case 0:
                                Mereni mereni = new Mereni(sessionFactory);
                                OknoMereni oknoMereni = new OknoMereni((table1.getSelectedRow() + 1), sessionFactory);
                                vypisMereni(sessionFactory);
                                break;
                            case 1:
                                MistoOdberu mistoOdberu = new MistoOdberu(sessionFactory);
                                mistoOdberu.smazOdberneMisto(table2.getSelectedRow() + 1);
                                vypisOdbernaMista(sessionFactory);
                                break;
                            case 2:
                                Platba platba = new Platba(sessionFactory);
                                platba.smazPlatbu(table3.getSelectedRow() + 1);
                                vypisPlatby(sessionFactory);
                                break;
                            case 3:
                                Produkt produkt = new Produkt(sessionFactory);
                                produkt.smazProdukt(table4.getSelectedRow() + 1);
                                vypisProdukty(sessionFactory);
                                break;
                            case 4:
                                Smlouva smlouva = new Smlouva(sessionFactory);
                                smlouva.smazSmlouvu(table5.getSelectedRow() + 1);
                                vypisSmlouvy(sessionFactory);
                                break;
                            case 5:
                                Zakaznik zakaznik = new Zakaznik(sessionFactory);
                                zakaznik.smazZakaznika(table6.getSelectedRow() + 1);
                                vypisZakazniky(sessionFactory);
                                break;
                        }
                        break;
                    case "Nový":
                        switch (tabbedPane1.getSelectedIndex()) {
                            case 0:
                                OknoMereni oknoMereni = new OknoMereni(sessionFactory);
                                break;
                            case 1:
                                OknoOdbernehoMista oknoOdbernehoMista = new OknoOdbernehoMista(sessionFactory);
                                break;
                            case 2:
                                OknoPlatby oknoPlatby = new OknoPlatby(sessionFactory);
                                break;
                            case 3:
                                OknoProduktu oknoProduktu = new OknoProduktu(sessionFactory);
                                break;
                            case 4:
                                OknoSmlouvy oknoSmlouvy = new OknoSmlouvy(sessionFactory);
                                break;
                            case 5:
                                OknoZakaznika oknoZakaznika = new OknoZakaznika(sessionFactory);
                                break;
                        }
                        break;
                    case "Smazat":
                        switch (tabbedPane1.getSelectedIndex()) {
                            case 0:
                                Mereni mereni = new Mereni(sessionFactory);
                                mereni.smazMereni(table1.getSelectedRow() + 1);
                                vypisMereni(sessionFactory);
                                break;
                            case 1:
                                MistoOdberu mistoOdberu = new MistoOdberu(sessionFactory);
                                Smlouva smlouva1 = new Smlouva(sessionFactory);
                                List<SmlouvaEntity> seznamSmluv = smlouva1.getSeznamSmluv();
                                int index = table2.getSelectedRow() + 1;
                                for (SmlouvaEntity smlouvaEntity : seznamSmluv) {
                                    if(smlouvaEntity.getOdberneMistoByIdMistaOdberu().getEan() == index){
                                        NelzeSmazat nelzeSmazat = new NelzeSmazat();
                                        nelzeSmazat.main();
                                        return;
                                    }
                                }
                                mistoOdberu.smazOdberneMisto(index);
                                vypisOdbernaMista(sessionFactory);
                                break;
                            case 2:
                                Platba platba = new Platba(sessionFactory);
                                platba.smazPlatbu(table3.getSelectedRow() + 1);
                                vypisPlatby(sessionFactory);
                                break;
                            case 3:
                                Produkt produkt = new Produkt(sessionFactory);
                                produkt.smazProdukt(table4.getSelectedRow() + 1);
                                vypisProdukty(sessionFactory);
                                break;
                            case 4:
                                Smlouva smlouva = new Smlouva(sessionFactory);
                                smlouva.smazSmlouvu(table5.getSelectedRow() + 1);
                                vypisSmlouvy(sessionFactory);
                                break;
                            case 5:
                                Zakaznik zakaznik = new Zakaznik(sessionFactory);
                                zakaznik.smazZakaznika(table6.getSelectedRow() + 1);
                                vypisZakazniky(sessionFactory);
                                break;
                        }
                        break;
                }

            }
        };
        novy.addActionListener(actionListener);
        změnitButton.addActionListener(actionListener);
        smazatButton.addActionListener(actionListener);
    }

    private void vypisZakazniky(SessionFactory sessionFactory) {
        Zakaznik zakaznik = new Zakaznik(sessionFactory);
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(ZakaznikEntity.class);
        String[] nazvySloupcu = {"jméno", "příjmení", "adresa"};
        for (int i = 0; i < nazvySloupcu.length; i++) {
            System.out.println(nazvySloupcu[i]);
        }

        DefaultTableModel zakaznikModel = new DefaultTableModel();
        zakaznikModel.setColumnIdentifiers(nazvySloupcu);
        table6.setModel(zakaznikModel);

        for (ZakaznikEntity zakaznikEntity : zakaznik.getSeznamZakazniku()) {
            zakaznikModel.addRow(new Object[]{
                    zakaznikEntity.getJmeno(),
                    zakaznikEntity.getPrijmeni(),
                    zakaznikEntity.getAdresa()
            });
        }
    }

    private void vypisProdukty(SessionFactory sessionFactory) {
        Produkt produkt = new Produkt(sessionFactory);
        ClassMetadata classMetadata = sessionFactory.getClassMetadata(ProduktyEntity.class);
        String[] nazvySloupcu = {"cena", "popis"};

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
        String[] nazvySloupcu = {"datum", "částka", "id smlouvy"};

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
        String[] nazvySloupcu = {"adresa"};

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
        String[] nazvySloupcu = {"datum", "hodnota", "Místo odběru"};

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
        Smlouva smlouva = new Smlouva(sessionFactory);

        String[] nazvySloupcu = {"datum uzavření smlouvy", "datum vypršení smlouvy", "zákazník", "produkt", "místo odběru"};

        DefaultTableModel smlouvyModel = new DefaultTableModel();
        smlouvyModel.setColumnIdentifiers(nazvySloupcu);

        for (SmlouvaEntity smlouvaEntity : smlouva.getSeznamSmluv()) {
            smlouvyModel.addRow(new Object[]{
                    smlouvaEntity.getDatumPocatku(),
                    smlouvaEntity.getDatumVyprseni(),
                    smlouvaEntity.getZakaznikByIdZakaznika().getId(),
                    smlouvaEntity.getProduktyByIdProduktu().getPopis(),
                    smlouvaEntity.getOdberneMistoByIdMistaOdberu().getAdresa()
            });
        }
        table5.setModel(smlouvyModel);
    }
}
