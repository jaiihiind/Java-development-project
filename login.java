package PROJECTS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;         // this needs to called as its subclass of awt...
import java.sql.*;

public class login extends JFrame implements ActionListener {             //? extends JFrame imports swing
    
    JButton lgn, cns;    // Should be globally defined to be able to write logic in main fuction. 
                        // and local decration should be removed. from JButton function

    JTextField b,q;   //  ---Declared login and password---
    Statement s;     //   ----Must for executing in >>  ResultSet rs = c.s.executeQuery(query); << this line

        login(){              // CONSTRUCTOR

            getContentPane().setBackground(Color.white);            // *Color (C->capital) AWT Package
            setLayout(null);   //swing ke layout ko null krne ke liye phir explictly JLabel apna dal denge...

//todo   ** Jlabel is used to write something in the empty frame
            JLabel a = new JLabel("Username");
            a.setBounds(50,20,100,30);  // (left_dist, top_dist, width, height)
            add(a);

            // Khali dabba BOX banane ke liye
            b = new JTextField();                                //? declared this *globally(--JTextField---)
            b.setBounds(150,28,150,20);        //? -----local declaration should be removed-------
            add(b);
            
            setSize(600,300);
            setLocation(500,250);
            setVisible(true);


//        *** PASSWORD (label and dabba)
            JLabel p = new JLabel("Password");
            p.setBounds(50,62,100,30);  // (left_dist, top_dist, width, height)
            add(p);

            // Khali dabba BOX banane ke liye
            q = new  JPasswordField();            //? declared this globally(--JTextField---)===don't declare anything here
            q.setBounds(150,70,150,20);
            add(q);
            
            setSize(600,300);
            setLocation(500,250);
            setVisible(true);


//**       *BUTTONS*
        lgn = new JButton("Login");
        lgn.setBounds(40, 140, 120, 30);
        lgn.setBackground(Color.BLACK);
        lgn.setForeground(Color.WHITE);
        lgn.addActionListener(this);
        add(lgn);
        
        JButton cns = new JButton("Cancel");
        cns.setBounds(180, 140, 120, 30);
        cns.setBackground(Color.BLACK);
        cns.setForeground(Color.WHITE);
        cns.addActionListener(this);
        add(cns);
        //cns.setFont(new Font("Tahoma", Font.BOLD, 15));



//      Adding logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/img2.png"));            
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);   
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);                                                        
        add(image);
        image.setBounds(350,20,200,200);   //necessary while not default image(to crop the image)
            


    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lgn){
            String Username = b.getText();     //? --value-- can be extracted from textField   (username-> b)
            String Password = q.getText();    //?  (password -> p )

  //?  ---------- Make a table in >> SQL << to store the username and password-----------
 //?         ------ Compulsory to add try-catch block while adding SQL query ---------

        String query = "select * from login where username='"+Username+"' and password='"+Password+"'";;      //MYsql query( ' )single inverted comma according to sql query


             try {
                login c = new login();     //--creating connect. with Mysql---
                ResultSet rs = c.s.executeQuery(query);   // s-statement   ResultSet - java.sql package
                
                if (rs.next()) {                 //checks if the --rs-- contains username & password
                    setVisible(false);        //? closes the current frame & opens next frame
                    new MenuBar();             //*  Directs user to the next page on 
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");   //! ---POPUP----
                    setVisible(false);
                }
                c.s.close();
            } catch (Exception a) {
                a.printStackTrace();
            }

        } else if (e.getSource() == cns){        // CANCEL button------closes the frame
            setVisible(false);
        }

        
    }

   


public static void main(String args[]){
    new login();

}
}