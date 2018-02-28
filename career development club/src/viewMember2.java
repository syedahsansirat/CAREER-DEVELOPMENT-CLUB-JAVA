
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.event.*;

public class viewMember2 implements ActionListener, MenuListener {

    JFrame jfm;
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    JPanel p1;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4, b5;
    JMenuBar menuBar;
    JMenu m1;
    String id, name, add, phn, dept, ssn, blood, age, gender, mail, fb,dd,mm,yyyy,dob;

    viewMember2(String s) {
        id = "" + s;
        jfm = new JFrame("CDC");
        jfm.setSize(400, 500);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(11, 2));

        menuBar = new JMenuBar();
        m1 = new JMenu("Home");

        m1.addMenuListener(this);
        menuBar.add(m1);

        jfm.setJMenuBar(menuBar);
        j1 = new JLabel();
        j2 = new JLabel();
        j3 = new JLabel();

        j4 = new JLabel();
        j5 = new JLabel();
        j6 = new JLabel();
        j7 = new JLabel();
        j8 = new JLabel();
        j9 = new JLabel();
        j10 = new JLabel();
        j11 = new JLabel();

        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();
        l6 = new JLabel();
        l7 = new JLabel();
        l8 = new JLabel();
        l9 = new JLabel();
        l10 = new JLabel();
        l11 = new JLabel();

        try {
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object  
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");

            //step3 create the statement object  
            Statement stmt = con.createStatement();

        //step4 execute query 
            ResultSet rs = stmt.executeQuery("select * from member where id=" + id);
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
         //   System.out.println(id + " " + name + " " + add + " " + phn + " " + dept + " " + ssn + " " + blood + " " + age + " " + gender + " " + mail + " " + fb);
        //  stmt.executeUpdate("INSERT INTO emp (ID,NAME,AGE) values (3,'sas',2)");

        //////////////////////
            //step5 close the connection object  
            con.close();

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(jfm, "Something Wrong or ID Does Not Exist");
        }
        char[] st= age.toCharArray();
        String yyyy = String.copyValueOf(st, 0, 4);
        String mm = String.copyValueOf(st,5,2);
        String dd = String.copyValueOf(st,8,2);
        dob= dd+"-"+mm+"-"+yyyy;

        j1.setText("Member Id :");
        j1.setForeground(Color.RED);
        j1.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l1.setText(id);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j2.setText("Member Name :");
        j2.setForeground(Color.RED);
        j2.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l2.setText(name);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j3.setText("Member Address :");
        j3.setForeground(Color.RED);
        j3.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l3.setText(add);
        l3.setForeground(Color.RED);
        l3.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j4.setText("Phone Number");
        j4.setForeground(Color.RED);
        j4.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l4.setText(phn);
        l4.setForeground(Color.RED);
        l4.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j5.setText("Department :");
        j5.setForeground(Color.RED);
        j5.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l5.setText(dept);
        l5.setForeground(Color.RED);
        l5.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j6.setText("Session :");
        j6.setForeground(Color.RED);
        j6.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l6.setText(ssn);
        l6.setForeground(Color.RED);
        l6.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j7.setText("Blood Group");
        j7.setForeground(Color.RED);
        j7.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l7.setText(blood);
        l7.setForeground(Color.RED);
        l7.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j8.setText("Member DoB :");
        j8.setForeground(Color.RED);
        j8.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l8.setText(dob);
        l8.setForeground(Color.RED);
        l8.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j9.setText("Gender :");
        j9.setForeground(Color.RED);
        j9.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l9.setText(gender);
        l9.setForeground(Color.RED);
        l9.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j10.setText("Mail Address :");
        j10.setForeground(Color.RED);
        j10.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l10.setText(mail);
        l10.setForeground(Color.RED);
        l10.setFont(new Font("Narkisim", Font.PLAIN, 14));

        j11.setText("Facebook ID :");
        j11.setForeground(Color.RED);
        j11.setFont(new Font("Narkisim", Font.PLAIN, 14));
        l11.setText(fb);
        l11.setForeground(Color.RED);
        l11.setFont(new Font("Narkisim", Font.PLAIN, 14));

        jfm.add(j1);
        jfm.add(l1);
        jfm.add(j2);
        jfm.add(l2);
        jfm.add(j3);
        jfm.add(l3);
        jfm.add(j4);
        jfm.add(l4);
        jfm.add(j5);
        jfm.add(l5);
        jfm.add(j6);
        jfm.add(l6);
        jfm.add(j7);
        jfm.add(l7);
        jfm.add(j8);
        jfm.add(l8);
        jfm.add(j9);
        jfm.add(l9);
        jfm.add(j10);
        jfm.add(l10);
        jfm.add(j11);
        jfm.add(l11);

        jfm.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
      //  String s= t.getText();
        // jfm.setVisible(false);
        // viewMember2 ob = new viewMember2(s);

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
