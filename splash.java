package PROJECTS;
import javax.swing.*;        //interface for develop.
import java.awt.*;          //abstract window toolkit -> helps to make window based applications

public class splash extends JFrame implements Runnable {
    
    splash () {
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/img.jpg"));            //folder ko bahar rakna hai project ke
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);   //frame ke img ko dhang se scale krne ke liye(awt package)
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);                                                        //! only takes imageIcon as input (not scaled image)
        add(image);
        
        Thread t;                     //declare thread class
        t = new Thread(this);        // object creation
        t.start();                  // will start the run method
        
        setVisible(true);    //window ko visible krne ke liye
        
        int x = 1;
        for (int i = 2; i <= 600; i+=4, x+=1) {
            setLocation(600 - ((i + x)/2), 350 - (i/2));                                     //in dono ko default values doge to direct image khulega
            setSize(i + 3*x, i + x/2);                                                      //loop b/c animation- size and loc. both changing
            try {
                Thread.sleep(10);                                                  //ye har eak frame ka time hai...10->for all frames
            } catch (Exception e) {}
        }        
    }
    


//   *** IN A COMPLETELY NEW CLASS ***
    public void run() {                                              //Ye FRAME ko gayab krne ke liye hai
        try {                                                       //to execute operation above(implements runnable)
            Thread.sleep(7000);
            setVisible(false);
            
            // Next Frame
         new login();
        } catch (Exception e) {
            
        }
    }
    



    public static void main(String[] args) {
        new splash();                                      //object banate hi, class ka constr. call hoga.
    }
}