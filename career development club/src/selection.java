
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class selection implements ActionListener, MenuListener {

    JFrame jfm;
    JLabel j1;
    JPanel p1;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4, b5;
    JMenuBar menuBar;
    JMenu m1;

    selection() {
        jfm = new JFrame("CDC");
        jfm.setSize(900, 670);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(5, 1));

        menuBar = new JMenuBar();
        m1 = new JMenu("<=Back");

        m1.addMenuListener(this);
        menuBar.add(m1);

        jfm.setJMenuBar(menuBar);

        b1 = new JButton("Add Member!");
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Narkisim", Font.BOLD, 50));
        b1.addActionListener(this);
        b2 = new JButton("Edit or Delete Member Information");
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Narkisim", Font.BOLD, 50));
        b2.addActionListener(this);
        b3 = new JButton("Update Activity");
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Narkisim", Font.BOLD, 50));
        b3.addActionListener(this);
        b4 = new JButton("View Activity");
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Narkisim", Font.BOLD, 50));
        b4.addActionListener(this);
        b5 = new JButton("View Member Information!");
        b5.setForeground(Color.BLACK);
        b5.setFont(new Font("Narkisim", Font.BOLD, 50));
        b5.addActionListener(this);
        jfm.add(b1);
        jfm.add(b2);
        jfm.add(b3);
        jfm.add(b4);
        jfm.add(b5);

        jfm.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            jfm.setVisible(false);
            addMem ob = new addMem();
        } else if (ae.getSource() == b2) {
            jfm.setVisible(false);
            editOrDel ob = new editOrDel();
        } else if (ae.getSource() == b3) {
            jfm.setVisible(false);
            activity ob = new activity();

        } else if (ae.getSource() == b4) {
            jfm.setVisible(false);
            showavg ob = new showavg();
        } else if (ae.getSource() == b5) {
            jfm.setVisible(false);
            viewMember ob = new viewMember();

        }

    }

    public static void main(String args[]) {
        selection ob = new selection();
    }

    public void menuSelected(MenuEvent me) {
        jfm.setVisible(false);
        one ob = new one();
    }

    public void menuDeselected(MenuEvent me) {
        //Nothing happens here       
    }

    public void menuCanceled(MenuEvent me) {
        //Nothing happens here
    }

}
