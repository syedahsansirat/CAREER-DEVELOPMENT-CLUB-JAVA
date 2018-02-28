
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.event.*;

public class showavg2 implements ActionListener, MenuListener {

    JFrame jfm;
    JLabel jl, jla, jlp, jm, jma, jr, jrg, jc, jca, jcp;
    JPanel p1, p2, p3, p4;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4, b5;
    JMenuBar menuBar;
    JMenu m1;
    String id, s1, s2, s3, s4, s5, s6, s7, s8, s11, s12;

    showavg2(String s) {
        id = "" + s;
        jfm = new JFrame("CDC");
        jfm.setSize(400, 600);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(true);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(4, 1));

        menuBar = new JMenuBar();
        m1 = new JMenu("Home");

        m1.addMenuListener(this);
        menuBar.add(m1);

        jfm.setJMenuBar(menuBar);

        jl = new JLabel();
        jla = new JLabel();
        jlp = new JLabel();

        jm = new JLabel();
        jma = new JLabel();
        jr = new JLabel();
        jrg = new JLabel();
        jc = new JLabel();
        jca = new JLabel();
        jcp = new JLabel();

        try {
            //step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object  
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");

            //step3 create the statement object  
            Statement stmt = con.createStatement();

            //step4 execute query 
            ResultSet rs = stmt.executeQuery("select count(classNo) from language where id=" + id);
            while (rs.next()) {
                s1 = "" + rs.getString(1);
            }
            ResultSet rs1 = stmt.executeQuery("select count(attandance) from language where id=" + id + " and attandance=" + 1);
            while (rs1.next()) {
                s2 = "" + rs1.getString(1);
            }
            s3 = s2 + " of " + s1 + " Classes.";

            jl.setText("Language Activity :");
            jl.setForeground(Color.BLUE);
            jl.setFont(new Font("Narkisim", Font.BOLD, 22));

            jla.setText("Attendance :" + s3);
            jla.setFont(new Font("Narkisim", Font.BOLD, 15));
            //  stmt.executeUpdate("INSERT INTO emp (ID,NAME,AGE) values (3,'sas',2)");
            ResultSet rs2 = stmt.executeQuery("select avg(performance) from language where id=" + id);
            while (rs2.next()) {
                s4 = "" + rs2.getString(1);
            }
            jlp.setText("Average Performance :" + s4);
            jlp.setFont(new Font("Narkisim", Font.BOLD, 15));

            jm.setText("Meeting Activity :");
            jm.setForeground(Color.BLUE);
            jm.setFont(new Font("Narkisim", Font.BOLD, 22));
            ResultSet rsm = stmt.executeQuery("select count(meetingNo) from meeting where id="+id);
            while (rsm.next()) {
                s11 = "" + rsm.getString(1);
            }

            ResultSet rs3 = stmt.executeQuery("select count(attandance) from meeting where id=" + id + " and attandance=" + 1);
            while (rs3.next()) {
                s5 = "" + rs3.getString(1);
            }
            jma.setText("Attendance : " + s5 + " of " + s11 + " Meetings");
            jma.setFont(new Font("Narkisim", Font.BOLD, 15));

            jr.setText("Average Result :");
            jr.setForeground(Color.BLUE);
            jr.setFont(new Font("Narkisim", Font.BOLD, 22));
            ResultSet rs4 = stmt.executeQuery("select avg(gpa) from result where id=" + id);
            while (rs4.next()) {
                s6 = "" + rs4.getDouble(1);
            }
            jrg.setText("CGPA : " + s6);
            jrg.setFont(new Font("Narkisim", Font.BOLD, 15));

            jc.setText("Random Competitions :");
            jc.setForeground(Color.BLUE);
            jc.setFont(new Font("Narkisim", Font.BOLD, 22));
            ResultSet rsc = stmt.executeQuery("select count(contestNo) from contest");
            while (rsc.next()) {
                s12 = "" + rsc.getString(1);
            }

            ResultSet rs5 = stmt.executeQuery("select count(attandance) from contest where id=" + id + " and attandance=" + 1);
            while (rs5.next()) {
                s7 = "" + rs5.getString(1);
            }
            jca.setText("Attendance : " + s7 + " of " + s12 + " competitions");
            jca.setFont(new Font("Narkisim", Font.BOLD, 15));

            ResultSet rs6 = stmt.executeQuery("select avg(performance) from contest where id=" + id);
            while (rs6.next()) {
                s4 = "" + rs6.getString(1);
            }
            jcp.setText("Average Performance :" + s4);
            jcp.setFont(new Font("Narkisim", Font.BOLD, 15));

            //step5 close the connection object  
            con.close();

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(jfm, "Something Wrong or ID Does Not Exist");
        }

        p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 1));

        p2 = new JPanel();
        p2.setLayout(new GridLayout(2, 1));

        p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 1));

        p4 = new JPanel();
        p4.setLayout(new GridLayout(3, 1));

        p1.add(jl);
        p1.add(jla);
        p1.add(jlp);
        p2.add(jm);
        p2.add(jma);
        p3.add(jr);
        p3.add(jrg);
        p4.add(jc);
        p4.add(jca);
        p4.add(jcp);

        jfm.add(p1);
        jfm.add(p2);
        jfm.add(p3);
        jfm.add(p4);

        jfm.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

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
