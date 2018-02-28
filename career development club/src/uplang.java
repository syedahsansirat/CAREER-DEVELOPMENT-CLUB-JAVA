
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.event.*;

public class uplang implements ActionListener, MenuListener {

    JFrame jfm;

    JPanel p1, p2, p3, p4, p5, p6, p6a, p6b, p6c, datePanel;
    ImageIcon img, imgb;
    JButton b1, b2, b3, b4;
    JMenuBar menuBar;
    JMenu m1;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, date, month, year;
    JLabel j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12;

    uplang() {
        jfm = new JFrame("CDC");
        jfm.setSize(500, 300);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(6, 2));

        j1 = new JLabel();
        j1.setText("Class Number :");
        t1 = new JTextField();

        j2 = new JLabel();
        j2.setText("Member ID :");
        t2 = new JTextField();

        j3 = new JLabel();
        j3.setText("Attendance (0/1) :");
        t3 = new JTextField();

        j4 = new JLabel();
        j4.setText("Performance (into 100) :");
        t4 = new JTextField();
        //t1.addActionListener(this);

        j5 = new JLabel();
        j5.setText("Date (date-mmonth-year)");
        datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1, 3));
        date = new JTextField(2);
        date.setText("dd");
        month = new JTextField(2);
        month.setText("mm");
        year = new JTextField(4);
        year.setText("yyyy");
        datePanel.add(date);
        datePanel.add(month);
        datePanel.add(year);

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
        jfm.add(j4);
        jfm.add(t4);
        jfm.add(j5);
        jfm.add(datePanel);
        ///////////
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
            String s4 = t4.getText();
            String dd = date.getText();
            String mm = month.getText();
            String yyyy = year.getText();

            String all = "INSERT into language (classNo,id,attandance,performance,ldate) values(" + s1 + "," + s2 + "," + s3 + "," + s4 + ",to_date('" + yyyy + mm + dd + "','YYYYMMDD'))";

            System.out.println(all);

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
        uplang ob = new uplang();
    }

}
