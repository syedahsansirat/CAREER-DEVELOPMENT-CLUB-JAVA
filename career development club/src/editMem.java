
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class editMem implements ActionListener, MenuListener {

    JFrame jfm;

    JPanel p1, p2, p3, p4, p5, p6, p6a, p6b, p6c;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4;
    JMenuBar menuBar;
    JMenu m1;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12;

    editMem() {
        jfm = new JFrame("CDC");
        jfm.setSize(500, 300);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(3, 1));

        j1 = new JLabel();
        j1.setText("Enter the ID of Member to Edit Her Information:");
        t1 = new JTextField();

        t1.addActionListener(this);

        b1 = new JButton("Search");
        b1.addActionListener(this);

        jfm.add(j1);
        jfm.add(t1);
        jfm.add(b1);
        jfm.setVisible(true);

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

    public void actionPerformed(ActionEvent ae) {
        String s1 = t1.getText();
        editMember obb = new editMember(s1);
    }

    public static void main(String args[]) {
        editMem ob = new editMem();
    }

}
