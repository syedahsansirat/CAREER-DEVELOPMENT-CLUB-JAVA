
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.event.*;

public class upresult implements ActionListener, MenuListener {

    JFrame jfm;

    JPanel p1, p2, p3, p4, p5, p6, p6a, p6b, p6c;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4;
    JMenuBar menuBar;
    JMenu m1;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11;
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12;

    upresult() {
        jfm = new JFrame("CDC");
        jfm.setSize(500, 300);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(4, 2));

        j1 = new JLabel();
        j1.setText("ID Number :");
        t1 = new JTextField();

        j2 = new JLabel();
        j2.setText("Semester :");
        t2 = new JTextField();

        j3 = new JLabel();
        j3.setText("GPA :");
        t3 = new JTextField();

        b1 = new JButton("Back");
        b1.addActionListener(this);
        b2 = new JButton("Save");
        b2.addActionListener(this);

        jfm.add(j1);
        jfm.add(t1);
        jfm.add(j2);
        jfm.add(t2);
        jfm.add(j3);
        jfm.add(t3);
        jfm.add(b1);
        jfm.add(b2);
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
        if (ae.getSource() == b1) {
            jfm.setVisible(false);
            activity ob = new activity();
        } else {
            String s1 = t1.getText();
            String s2 = t2.getText();
            String s3 = t3.getText();

            String all = "INSERT into result (id,semester,gpa) values(" + s1 + "," + s2 + "," + s3 + ")";
            System.out.print(all);
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
                Statement stmt = con.createStatement();
                stmt.executeUpdate(all);
                con.close();
                JOptionPane.showMessageDialog(jfm, "Done!");
                jfm.setVisible(false);
                activity ob = new activity();

            } catch (Exception ee) {
                JOptionPane.showMessageDialog(jfm, "Something Wrong");
            }

        }
    }

    public static void main(String args[]) {
        upresult ob = new upresult();
    }

}
