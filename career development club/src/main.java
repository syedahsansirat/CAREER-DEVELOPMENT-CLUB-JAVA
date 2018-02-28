
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class main implements ActionListener, KeyListener {

    JFrame jfm;
    JPanel p0, p1, p2, p3, p4, p5, p6;
    JLabel j1, j2, j3, j4;
    JTextField t1, t2;
    JButton b1;

    String a = "", b = "";

    main() {
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
            //System.out.println(a);
            //System.out.println(b);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        jfm = new JFrame("CDC");
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
        //j4 = new JLabel("<html>Default Username: admin<br>Default Password: 1234</html>");

        j1 = new JLabel("USERNAME: ");
        j1.setForeground(Color.RED);
        j1.setFont(new Font("Serif", Font.BOLD, 15));

        t1 = new JTextField(20);
        //p3.add(j4);
        p1.add(j1);
        p1.add(t1);

        j2 = new JLabel("PASSWORD: ");
        j2.setForeground(Color.RED);
        j2.setFont(new Font("Serif", Font.BOLD, 15));
        //pass = new JPasswordField(20);
        p2.add(j2);
        //p3.add(pass);
        t2 = new JTextField(20);
        p2.add(t2);
        p0.add(p3);
        p0.add(p1);
        p0.add(p2);

        p4 = new JPanel();
        p4.setLayout(new GridLayout(2, 1));

        p5 = new JPanel();
        b1 = new JButton("ENTER");
        b1.addActionListener(this);
        p5.add(b1);

        p6 = new JPanel();

        p4.add(p5);
        p4.add(p6);

        jfm.add(p0);
        jfm.add(p4);
        jfm.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s1 = t1.getText();
        String s2 = t2.getText();

        //String s2 = t1.getText();
        //  System.out.println(str);
        //System.out.println(a);
        //int b = Integer.parseInt(str);
        if (s1.matches(a) & s2.matches(b)) {

            jfm.setVisible(false);
            loged_in ob = new loged_in();

        } else {
            JOptionPane.showMessageDialog(jfm, "WRONG USERNAME OR PASSWORD");

        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("Hello");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static void main(String args[]) {
        main ob = new main();
    }

}
