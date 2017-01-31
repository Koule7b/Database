package Databaze.Grafika.Okna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrazdneKolonky extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;

    public PrazdneKolonky() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        dispose();
    }

    public static void main() {
        PrazdneKolonky dialog = new PrazdneKolonky();
        dialog.pack();
        dialog.setVisible(true);

    }
}
