
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class showavg implements ActionListener, MenuListener {

    JFrame jfm;
    JLabel j1;
    JPanel p1;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4, b5;
    JMenuBar menuBar;
    JMenu m1;
    JTextField t;

    showavg() {
        jfm = new JFrame("CDC");
        jfm.setSize(450, 330);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(3, 1));

        menuBar = new JMenuBar();
        m1 = new JMenu("Home");

        m1.addMenuListener(this);
        menuBar.add(m1);

        jfm.setJMenuBar(menuBar);

        j1 = new JLabel("Enter ID Number to view Member's Activity:");
        t = new JTextField(15);
        b1 = new JButton("Go");
        t.addActionListener(this);
        b1.addActionListener(this);
        jfm.add(j1);
        jfm.add(t);
        jfm.add(b1);
        jfm.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        String s = t.getText();
        jfm.setVisible(false);
        showavg2 ob = new showavg2(s);

    }

    public static void main(String args[]) {
        showavg ob = new showavg();
    }

    public void menuSelected(MenuEvent me) {
        jfm.setVisible(false);
        selection ob = new selection();
    }

    public void menuDeselected(MenuEvent me) {
        //Nothing happens here       
    }

    public void menuCanceled(MenuEvent me) {
        //Nothing happens here
    }

}
