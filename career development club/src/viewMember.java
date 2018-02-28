
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.event.*;

public class viewMember implements ActionListener, MenuListener {

    JFrame jfm;
    JLabel j1;
    JPanel p1;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4, b5;
    JMenuBar menuBar;
    JMenu m1;
    JTextField t;

    viewMember() {
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

        j1 = new JLabel("Enter ID Number to view Member Info:");
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

        String idd = null;

        if (s != null && !s.isEmpty()) {

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
                Statement stmt = con.createStatement();
                ResultSet rss = stmt.executeQuery("select id from member where id=" + s);
                while (rss.next()) {
                    idd = "" + rss.getLong(1);
                }
                con.close();

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(jfm, "Something Wrong or ID Does Not Exist");
                
            }//
            if (idd != null && !idd.isEmpty()) {
                jfm.setVisible(false);
                viewMember2 ob = new viewMember2(s);
            } else {
                JOptionPane.showMessageDialog(jfm, "This Content is not available...");
            }

        } else {
            JOptionPane.showMessageDialog(jfm, "Enter Real Id");
        }

    }

    public static void main(String args[]) {
        viewMember ob = new viewMember();
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
