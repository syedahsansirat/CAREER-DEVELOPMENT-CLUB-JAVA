
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class loged_in implements ActionListener {

    JFrame jfm;
    JLabel j1, j2, j3;
    JPanel p1, p2, p3, p4, p5, p6;
    ImageIcon img, imgb;
    JButton b1, b2;

    loged_in() {
        jfm = new JFrame("CDC");
        jfm.setSize(500, 500);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(2, 2));
        img = new ImageIcon("login.jpg");
        imgb = new ImageIcon("changepin.jpg");
        b1 = new JButton("Login");
        b1.setIcon(img);
        b1.addActionListener(this);
        b2 = new JButton("Change Pin");
        b2.setIcon(imgb);
        b2.addActionListener(this);
        jfm.add(b1);
        jfm.add(b2);

        jfm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            jfm.setVisible(false);
            one ob = new one();
           // changepass ob = new changepass();

        }
        if (e.getSource() == b2) {
            jfm.setVisible(false);
            changepass ob = new changepass();

        }

    }

    public static void main(String args[]) {
        loged_in ob = new loged_in();
    }

}
