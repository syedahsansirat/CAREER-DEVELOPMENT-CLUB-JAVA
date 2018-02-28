
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;





public class YesNo implements ActionListener {
    JFrame jfm2;
    JButton yes,no;
    JLabel surity;
    JPanel p;
    int i;
    
    YesNo(int x)                 
    {
         jfm2 = new JFrame();
         i=x;
                    jfm2.setSize(300, 100);
                    jfm2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jfm2.setResizable(false);
                    jfm2.setLocationRelativeTo(null);
                    jfm2.setLayout(new GridLayout(2, 1));
                     yes = new JButton("yes");
                     no = new JButton("No");
                    surity = new JLabel("Are you Sure To Delete all information of id = "+i);
                    jfm2.add(surity);
                    p= new JPanel();
                    p.add(yes);
                    p.add(no);
                    jfm2.add(p);
                    jfm2.setVisible(true);
                    yes.addActionListener( this);
                    no.addActionListener(this);
        
    }
   public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==yes)
       {
         
           
           
           
            String delResult = "delete from  result where id=" + i;
            String delContest = "delete from  contest where id=" + i;
            String delMeeting = "delete from  meeting where id=" + i;
            String delLanguage = "delete from  language where id=" + i;
            String del = "delete from  member where id=" + i;

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:xe", "cdc", "12345");
                Statement stmt = con.createStatement();
      //  PreparedStatement pstmt = null;
                //   String ss= "UPDATE loging set pin = "+str1+" where serial = 1";
                //  System.out.print(a2);
                // pstmt = con.prepareStatement(ss);
                stmt.executeUpdate(delResult);
                stmt.executeUpdate(delContest);
                stmt.executeUpdate(delMeeting);
                stmt.executeUpdate(delLanguage);
                stmt.executeUpdate(del);
                con.close();
                // System.out.print(ss);
                JOptionPane.showMessageDialog(jfm2, "Member Deleted!");
                jfm2.setVisible(false);

            } catch (Exception ee) {
                JOptionPane.showMessageDialog(jfm2, "Something Went Wrong");
                System.out.println(ee);
                jfm2.setVisible(false);
                selection ob = new selection();
            }
           
           
           
       }
       else
       {
           jfm2.setVisible(false);
       }
       
       
   }
    
    
}
