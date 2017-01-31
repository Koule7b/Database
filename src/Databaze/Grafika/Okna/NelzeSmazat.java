package Databaze.Grafika.Okna;

import javax.swing.*;
import java.awt.event.*;

public class NelzeSmazat extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public NelzeSmazat() {
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
        NelzeSmazat dialog = new NelzeSmazat();
        dialog.pack();
        dialog.setVisible(true);
    }
}
