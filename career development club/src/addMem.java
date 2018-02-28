

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class addMem implements ActionListener, MenuListener {

    JFrame jfm;

    JPanel p1, p2, p3, p4, p5, p6, p6a, p6b, p6c, dobPanel;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4;
    JMenuBar menuBar;
    JMenu m1;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8a, t8b, t8c, t9, t10, t11;
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, jb12, jb13;

    addMem() {
        jfm = new JFrame("CDC");
        jfm.setSize(500, 670);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(4, 3));

        menuBar = new JMenuBar();
        m1 = new JMenu("<- Back");
        m1.addMenuListener(this);
        menuBar.add(m1);
        jfm.setJMenuBar(menuBar);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));

        j1 = new JLabel();
        j1.setText("<html>ID*</html>");
        j1.setBorder(new EmptyBorder(0, 100, 0, 0));
        t1 = new JTextField();

        j2 = new JLabel();
        j2.setText("Name*");
        j2.setBorder(new EmptyBorder(0, 100, 0, 0));
        t2 = new JTextField();

        j3 = new JLabel();
        j3.setText("Address");
        j3.setBorder(new EmptyBorder(0, 100, 0, 0));
        t3 = new JTextField();

        j4 = new JLabel();
        j4.setText("Phone");
        j4.setBorder(new EmptyBorder(0, 100, 0, 0));
        t4 = new JTextField();
        p1.add(j1);
        p1.add(t1);
        p1.add(j2);
        p1.add(t2);
        p1.add(j3);
        p1.add(t3);
        p1.add(j4);
        p1.add(t4);
        jfm.add(p1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 1));

        j5 = new JLabel();
        j5.setText("depertment");
        j5.setBorder(new EmptyBorder(0, 100, 0, 0));
        t5 = new JTextField();

        j6 = new JLabel();
        j6.setText("session");
        j6.setBorder(new EmptyBorder(0, 100, 0, 0));
        t6 = new JTextField();

        j7 = new JLabel();
        j7.setText("bloodGroup");
        j7.setBorder(new EmptyBorder(0, 100, 0, 0));
        t7 = new JTextField();

        j8 = new JLabel();
        j8.setText("Date of Birth (d-m-y)");
        j8.setBorder(new EmptyBorder(0, 100, 0, 0));
        t8a = new JTextField(3);
        t8b = new JTextField(3);
        t8c = new JTextField(4);
        dobPanel = new JPanel();
        dobPanel.add(t8a);
        dobPanel.add(t8b);
        dobPanel.add(t8c);

        p2.add(j5);
        p2.add(t5);
        p2.add(j6);
        p2.add(t6);
        p2.add(j7);
        p2.add(t7);
        p2.add(j8);
        p2.add(dobPanel);
        jfm.add(p2);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(4, 1));

        j9 = new JLabel();
        j9.setText("Gender");
        j9.setBorder(new EmptyBorder(0, 100, 0, 0));
        t9 = new JTextField();

        j10 = new JLabel();
        j10.setText("Email*");
        j10.setBorder(new EmptyBorder(0, 100, 0, 0));
        t10 = new JTextField();

        j11 = new JLabel();
        j11.setText("Facebook ID");
        j11.setBorder(new EmptyBorder(0, 100, 0, 0));
        t11 = new JTextField();

        p3.add(j9);
        p3.add(t9);
        p3.add(j10);
        p3.add(t10);
        p3.add(j11);
        p3.add(t11);
        //  p3.add(j8);
        //  p3.add(t8);
        jfm.add(p3);

        p4 = new JPanel();
        p4.setLayout(new GridLayout(2, 3));
        b1 = new JButton("SAVE");
        b1.setForeground(Color.green);
        b1.setFont(new Font("Narkisim", Font.BOLD, 40));
        jb12 = new JLabel("");
        jb13 = new JLabel("");
        p4.add(jb12);
        b1.addActionListener(this);
        p4.add(b1);
        p4.add(jb13);

        jfm.add(p4);
        jfm.setVisible(true);

    }

    public static void main(String args[]) {
        addMem ob = new addMem();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String s1 = t1.getText();
        String s2 = t2.getText();
        String s3 = t3.getText();
        String s4 = t4.getText();
        String s5 = t5.getText();
        String s6 = t6.getText();
        String s7 = t7.getText();

        String s8a = t8a.getText();///////////
        String s8b = t8b.getText();///////////
        String s8c = t8c.getText();///////////
        String s9 = t9.getText();
        String s10 = t10.getText();
        String s11 = t11.getText();

        boolean flag = false;
        for (char c : s10.toCharArray()) {
            if (c == '@') {
                flag = true;
            }

        }

        if (flag == false) {
            JOptionPane.showMessageDialog(jfm, "Wrong Email Address.");

        } else {
            String all = "INSERT INTO member(id,m_name,m_address,m_phone,m_depertment,m_session,m_bloodGroup,m_dob,m_gender,m_email,m_fbId)VALUES(" + s1 + ",'" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "',to_date('" + s8c + s8b + s8a + "','YYYYMMDD')" + ",'" + s9 + "','" + s10 + "','" + s11 + "')";
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
                Statement stmt = con.createStatement();
      //  PreparedStatement pstmt = null;
                //   String ss= "UPDATE loging set pin = "+str1+" where serial = 1";

                // pstmt = con.prepareStatement(ss);
                stmt.executeUpdate(all);
                con.close();
                // System.out.print(ss);
                JOptionPane.showMessageDialog(jfm, "Member Added!");
                jfm.setVisible(false);
                addMem ob = new addMem();

            } catch (Exception ee) {
                JOptionPane.showMessageDialog(jfm, "Something Wrong or Fill Up * marked Text");
            }
        }

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
