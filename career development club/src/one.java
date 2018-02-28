
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class one implements ActionListener, MenuListener {

    JFrame jfm;
    JLabel j1;
    JPanel p1;
    ImageIcon img, imgb;
    JButton b1, b2;
    JMenuBar menuBar;
    JMenu m1;

    one() {

        jfm = new JFrame("CDC");
        jfm.setSize(900, 670);
        jfm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jfm.setLocationRelativeTo(null);
        jfm.setLayout(new BorderLayout());
        j1 = new JLabel();
        j1.setLayout(new FlowLayout());
        img = new ImageIcon("i.gif");
        j1.setIcon(img);

        /*  menuBar = new JMenuBar();
         m1 = new JMenu("<=Back");
       
         m1.addMenuListener(this);
         menuBar.add(m1);
        
         jfm.setJMenuBar(menuBar);*/
        p1 = new JPanel();

       // img = new ImageIcon("img/fbutton.jpg");
        //  b1 = new JButton("START");
        b1 = new JButton("Log Out");
        b1.addActionListener(this);
        b2 = new JButton("Start");
        b2.addActionListener(this);
        //b1.setIcon(img);
        // j1.add(b1);
        j1.add(b2);
        j1.add(b1);
        p1.add(j1);

        jfm.add(p1);

        jfm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b2)
        {
            jfm.setVisible(false);
            selection ob = new selection();
        }
        else if(ae.getSource() == b1)
        {
            jfm.setVisible(false);
            main ob = new main();
        }
    }

    public static void main(String args[]) {
        one ob = new one();
    }

    public void menuSelected(MenuEvent me) {

    }

    public void menuDeselected(MenuEvent me) {
        //Nothing happens here       
    }

    public void menuCanceled(MenuEvent me) {
        //Nothing happens here
    }

}
