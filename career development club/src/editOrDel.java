
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.event.*;

public class editOrDel implements ActionListener, MenuListener {

    JFrame jfm;
    JLabel j1;
    JPanel p1, p2, p3, pp1, pp2, pp3, pp4, pp5, pp6;
    ImageIcon img, imgb;
    JButton b1, b2, b3;
    JMenuBar menuBar;
    JTextField jt;
    JMenu m1;

    editOrDel() {
        jfm = new JFrame("CDC");
        jfm.setSize(600, 200);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new GridLayout(2, 2));

        menuBar = new JMenuBar();
        m1 = new JMenu("Back");

        m1.addMenuListener(this);
        menuBar.add(m1);

        jfm.setJMenuBar(menuBar);

        pp1 = new JPanel();
        pp2 = new JPanel();
        pp3 = new JPanel();
        pp4 = new JPanel();
        pp5 = new JPanel();
        pp6 = new JPanel();

        p1 = new JPanel();
        p2 = new JPanel();
        b1 = new JButton("Edit");
        // img = new ImageIcon("edit.jpg");
        b1.setIcon(img);
        b1.addActionListener(this);
        b2 = new JButton("Delete");
        // imgb = new ImageIcon("delete.jpg");
        b2.setIcon(imgb);
        b2.addActionListener(this);
        //p2.setLayout(new GridLayout(1,2));
        //p1.setLayout(new GridLayout(2,1));
        b3 = new JButton("Back");
        b3.addActionListener(this);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        j1 = new JLabel();
        j1.setText("Enter ID:");
        //    j1.setForeground(Color.RED);
        //j1.setFont(new Font("Narkisim", Font.BOLD, 10));

        jt = new JTextField(10);
        p1.add(j1);
        p1.add(jt);

        pp2.add(p1);
        pp5.add(p2);

        //pp6.add(b3);
        jfm.add(pp1);
        jfm.add(pp2);
        jfm.add(pp3);
        jfm.add(pp4);
        jfm.add(pp5);
        jfm.add(pp6);

        jfm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String idd = null;
            String s1 = jt.getText();
            if (s1 != null && !s1.isEmpty()) {
   
            try { 
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
            Statement stmt = con.createStatement();
            ResultSet rss = stmt.executeQuery("select id from member where id=" + s1);
            while (rss.next()) {
                idd =""+rss.getLong(1);
            }     
            con.close();

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(jfm, "Something Wrong or ID Does Not Exist");
        }//
                if(idd!= null && !idd.isEmpty())
                {
                    editMember ob = new editMember(s1);
                          jfm.setVisible(false);
                }
                else
                {
                JOptionPane.showMessageDialog(jfm, "This Content is not available...");
                }
                
            } else 
                JOptionPane.showMessageDialog(jfm, "Enter Real Id");
            }
        
    
        else if (ae.getSource() == b2) {

            String s1 = jt.getText();
            String s2 = new String();
            int i = Integer.parseInt(s1);
            try {
                //step1 load the driver class  
                Class.forName("oracle.jdbc.driver.OracleDriver");

                //step2 create  the connection object  
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");

                //step3 create the statement object  
                Statement stmt = con.createStatement();

                //step4 execute query 
                ResultSet rs = stmt.executeQuery("select id from member where id=" + i);
                while (rs.next()) {
                    s2 = "" + rs.getLong(1);

                }
                con.close();

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(jfm, "Something Wrong or ID Does Not Exist");
            }

            if (s2 != null && !s2.isEmpty()) {

                YesNo ob = new YesNo(i);

            } else {
                JOptionPane.showMessageDialog(jfm, "No MEMBER EXIST OF ID " + s1);
            }

        } else if (ae.getSource() == b3) {
            jfm.setVisible(false);
            selection ob = new selection();
        }

    }

    public static void main(String args[]) {
        editOrDel ob = new editOrDel();
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
