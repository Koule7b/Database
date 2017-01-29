import javax.swing.*;

/**
 * Created by stepanmudra on 18.01.17.
 */
public class kvu extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTable table4;
    private JTable table5;
    private JTable table6;
    private JButton button1;
    private JButton button2;
    private JButton button3;

    public kvu(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel1);

        panel1.add(tabbedPane1);
        pack();
        setVisible(true);
    }
}
