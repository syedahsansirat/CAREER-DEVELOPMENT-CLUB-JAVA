
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

public class editMember implements ActionListener, MenuListener {

    JFrame jfm;
    String x;

    JPanel p1, p2, p3, p4, p5, p6, p6a, p6b, p6c,dobPanel;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4;
    JMenuBar menuBar;
    JMenu m1;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8a,t8b,t8c, t9, t10, t11;
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, jx,jb12,jb13;
    String id, name, add, phn, dept, ssn, blood, age, gender, mail, fb,year,month,date;

    editMember(String s) {
        x = "" + s;
        jfm = new JFrame("CDC");
        jfm.setSize(500, 670);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(4, 1));
        /////////////
        
        
        
        try {
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object  
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");

            //step3 create the statement object  
            Statement stmt = con.createStatement();

        //step4 execute query 
            ResultSet rs = stmt.executeQuery("select * from member where id=" + x);
            while (rs.next()) {
                id = "" + rs.getLong(1);
                name = rs.getString(2);
                add = rs.getString(3);
                phn = "" + rs.getString(4);
                dept = rs.getString(5);
                ssn = rs.getString(6);
                blood = rs.getString(7);
                age = "" + rs.getDate(8);
                gender = rs.getString(9);
                mail = rs.getString(10);
                fb = rs.getString(11);

            }
            System.out.println(age);
            con.close();

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(jfm, "Something Wrong or ID Does Not Exist");
        }//
        char[] st= age.toCharArray();
        String year = String.copyValueOf(st, 0, 4);
        String month = String.copyValueOf(st,5,2);
        String date = String.copyValueOf(st,8,2);
        
        
        
        
        /////////////////////
        
        
        
        
        
        
        
        
        

        menuBar = new JMenuBar();
        m1 = new JMenu("Home");
        m1.addMenuListener(this);
        menuBar.add(m1);
        jfm.setJMenuBar(menuBar);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));

        j1 = new JLabel();
        j1.setText("ID=" + s);
        j1.setBorder(new EmptyBorder(0, 100, 0, 0));
        
        // t1 = new JTextField();

        j2 = new JLabel();
        j2.setText("Name");
        j2.setBorder(new EmptyBorder(0, 100, 0, 0));
        t2 = new JTextField();
        t2.setText(name);
        

        j3 = new JLabel();
        j3.setText("Address");
        j3.setBorder(new EmptyBorder(0, 100, 0, 0));
        t3 = new JTextField();
        t3.setText(add);
        
        
        j4 = new JLabel();
        j4.setText("Phone");
        j4.setBorder(new EmptyBorder(0, 100, 0, 0));
        t4 = new JTextField();
        t4.setText(phn);
        
        
        p1.add(j1);
        jx = new JLabel();
        p1.add(jx);
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
        t5.setText(dept);
        

        j6 = new JLabel();
        j6.setText("session");
        j6.setBorder(new EmptyBorder(0, 100, 0, 0));
        t6 = new JTextField();
        t6.setText(ssn);
        
        
        j7 = new JLabel();
        j7.setText("bloodGroup");
        j7.setBorder(new EmptyBorder(0, 100, 0, 0));
        t7 = new JTextField();
        t7.setText(blood);

        j8 = new JLabel();
        j8.setText("Date of Birth(dd-mm-yyyy)");
        j8.setBorder(new EmptyBorder(0, 100, 0, 0));
          t8a = new JTextField(4);
          t8a.setText(date);
        t8b = new JTextField(4);
        t8b.setText(month);
        t8c = new JTextField(4);
        t8c.setText(year);
        dobPanel = new JPanel();
        dobPanel.add(t8a);
        dobPanel.add(t8b);
        dobPanel.add(t8c);
      //  t8.setText(age);
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
        t9.setText(gender);

        j10 = new JLabel();
        j10.setText("Email");
        j10.setBorder(new EmptyBorder(0, 100, 0, 0));
        t10 = new JTextField();
        t10.setText(mail);

        j11 = new JLabel();
        j11.setText("FbID");
        j11.setBorder(new EmptyBorder(0, 100, 0, 0));
        t11 = new JTextField();
        t11.setText(fb);

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

    public void actionPerformed(ActionEvent ae) {
        //   String s1 = t1.getText();
        String name = t2.getText();
        String address = t3.getText();
        String phone = t4.getText();
        String depertment = t5.getText();
        String session = t6.getText();
        String bloodGroup = t7.getText();
        String dd = t8a.getText();
        String mm = t8b.getText();
        String yyyy = t8c.getText();
        String gender = t9.getText();
        String email = t10.getText();
        String fbId = t11.getText();

        String chng = "  UPDATE member set  id = " + x
                + ",m_name = '" + name + "'"
                + ",m_address = '" + address + "'"
                + ",m_phone = '" + phone + "'"
                + ",m_depertment = '" + depertment + "'"
                + ",m_session = '" + session + "'"
                + ",m_bloodGroup = '" + bloodGroup + "'"
                + ",m_dob = to_date('" + yyyy + mm + dd + "','YYYYMMDD') "      //
                + ",m_gender = '" + gender + "'"
                + ",m_email = '" + email + "'"
                + ",m_fbId = '" + fbId + "'"
                + " where id = " + x;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
            Statement stmt = con.createStatement();
      //  PreparedStatement pstmt = null;
            //   String ss= "UPDATE loging set pin = "+str1+" where serial = 1";
            //  System.out.print(a2);
            // pstmt = con.prepareStatement(ss);
            stmt.executeUpdate(chng);
            // System.out.println(chng);
            con.close();
            // System.out.print(ss);
            JOptionPane.showMessageDialog(jfm, "Done!");
            jfm.setVisible(false);
            one ob = new one();

        } catch (Exception ee) {
            System.out.println(ee);
            JOptionPane.showMessageDialog(jfm, "Something Wrong");
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
