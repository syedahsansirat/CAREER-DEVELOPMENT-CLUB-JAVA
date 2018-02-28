
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class changepass implements ActionListener {

    JFrame jfm;
    JPanel p0, p1, p2, p3, p4, p5, p6;
    JLabel j1, j2, j3, j4, jnew;
    JTextField oldu, oldp, newu, newp;
    JButton b1, b2, b3, back;

    String a = "", b = "";

    public changepass() {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");

            Statement stmt = con.createStatement();
            String s = "select u_name,pass from admin where serial=1";
            ResultSet rs = stmt.executeQuery(s);
            while (rs.next()) {
                a = "" + rs.getString(1);
                b = "" + rs.getString(2);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        jfm = new JFrame("Change Pass");
        jfm.setSize(450, 500);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(2, 1));

        p0 = new JPanel();
        p0.setLayout(new GridLayout(3, 1));
        p3 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        j4 = new JLabel("Old User Name:");
        j4.setForeground(Color.RED);
        j4.setFont(new Font("Serif", Font.BOLD, 15));
        oldu = new JTextField(20);

        j1 = new JLabel("Old Password: ");
        j1.setForeground(Color.RED);
        j1.setFont(new Font("Serif", Font.BOLD, 15));

        oldp = new JTextField(20);
        p3.add(j4);
        p3.add(oldu);
        p1.add(j1);
        p1.add(oldp);

        j2 = new JLabel("New Username: ");
        j2.setForeground(Color.RED);
        j2.setFont(new Font("Serif", Font.BOLD, 15));
        p2.add(j2);
        newu = new JTextField(20);
        p2.add(newu);
        p0.add(p3);
        p0.add(p1);
        p0.add(p2);

        p4 = new JPanel();
        p4.setLayout(new GridLayout(2, 1));
        jnew = new JLabel("New Password: ");
        jnew.setForeground(Color.RED);
        jnew.setFont(new Font("Serif", Font.BOLD, 15));
        p5 = new JPanel();
        newp = new JTextField(20);
        p5.add(jnew);
        p5.add(newp);
        newp.addActionListener(this);
        p6 = new JPanel();
        b1 = new JButton("ENTER");
        b1.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);
        p6.add(b1);
        p6.add(back);

        p4.add(p5);
        p4.add(p6);

        jfm.add(p0);
        jfm.add(p4);
        jfm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1 || e.getSource() == newp) {

            String s1 = oldu.getText();
            String s2 = oldp.getText();
            String s3 = newu.getText();
            String s4 = newp.getText();

     //  System.out.println(str);
            //int b = Integer.parseInt(str);
            if (s1.matches(s3)) {
                JOptionPane.showMessageDialog(jfm, "You Type The Old User Name");
                changepass ob = new changepass();
                jfm.setVisible(false);
                //System.exit(0);
                //changepass ob = new changepass();
            } else if (s2.matches(s4)) {
                JOptionPane.showMessageDialog(jfm, "You Type The Old Password");
                changepass ob = new changepass();
                jfm.setVisible(false);
                //System.exit(0);
                //changepass ob = new changepass();
            } else if (s1.matches(a) & s2.matches(b)) {

                try {

                    if (s3 == null || s3.isEmpty()) {
                        String chngP = "UPDATE admin set pass='" + s4 + "' where serial = 1";
                        System.out.println(chngP);
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
                        Statement stmt = con.createStatement();
                        //  PreparedStatement pstmt = null;
                        //  String chngUN = "UPDATE admin set u_name ='" + s1 + "' where serial = 1";

                      //  System.out.print(a2);
                        // pstmt = con.prepareStatement(ss);
                        stmt.executeUpdate(chngP);
                        con.close();
                        // System.out.print(ss);
                        JOptionPane.showMessageDialog(jfm, "Changed!");

                    } else if (s4 == null || s4.isEmpty()) {

                        String chngUN = "UPDATE admin set u_name ='" + s3 + "' where serial = 1";
                        System.out.println(chngUN);
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
                        Statement stmt = con.createStatement();
                        //  PreparedStatement pstmt = null;

                      //  String chngP = "UPDATE admin set pass='" + s2 + "' where serial = 1";
                        //  System.out.print(a2);
                        // pstmt = con.prepareStatement(ss);
                        stmt.executeUpdate(chngUN);
                        //  stmt.executeUpdate(chngP);
                        con.close();
                        // System.out.print(ss);
                        JOptionPane.showMessageDialog(jfm, "Changed!");

                    } else {

                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con = DriverManager.getConnection(
                                "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
                        Statement stmt = con.createStatement();
                        //  PreparedStatement pstmt = null;
                        String chngUN = "UPDATE admin set u_name ='" + s3 + "' where serial = 1";
                        String chngP = "UPDATE admin set pass='" + s4 + "' where serial = 1";
                        //  System.out.print(a2);
                        // pstmt = con.prepareStatement(ss);

                        stmt.executeUpdate(chngUN);
                        stmt.executeUpdate(chngP);
                        con.close();
                        // System.out.print(ss);
                        JOptionPane.showMessageDialog(jfm, "Changed!");

                    }
                } catch (Exception ee) {
                    System.out.println(ee);
                }

                jfm.setVisible(false);
                one ob = new one();
            } else {
                JOptionPane.showMessageDialog(jfm, "Old Username or Password is incorrect");

            }

        } /////////////////////////  
        else if (e.getSource() == back) {
            jfm.setVisible(false);
            loged_in ob = new loged_in();
        }

    }

    public static void main(String args[]) {
        changepass ob = new changepass();
    }

}
