package PROJECTS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JFrame implements ActionListener {
    
    MenuBar(){

    setSize(1400, 840);    //LAPTOP screen size

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/img3.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1400, 780, Image.SCALE_DEFAULT);  //image ka size
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image);    
    

// * MAKING A MENU-BAR
    JMenuBar mb = new JMenuBar(); //!--------***MAIN DECLARATION***-------   (isi me sare add honge)

    JMenu new1 = new JMenu("New Information");   //Main button 
    new1.setForeground(Color.BLUE);               //text's color
    mb.add(new1);                                //Adding the comp. into menubar

// *Sub-list of main menu buttons ( branches)   *** (JMenuItem)
    JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
    facultyInfo.setBackground(Color.WHITE);
    //facultyInfo.addActionListener(this);
    new1.add(facultyInfo);
    
    JMenuItem studentInfo = new JMenuItem("New Student Information");
    studentInfo.setBackground(Color.WHITE);
    //studentInfo.addActionListener(this);
    new1.add(studentInfo);



//  -------------Details---------------------
    JMenu details = new JMenu("View Details");
    details.setForeground(Color.RED);      //DEFAULT Black
    mb.add(details);
        
    JMenuItem facultydetails = new JMenuItem("View Faculty Details");
    facultydetails.setBackground(Color.WHITE);
    facultydetails.addActionListener(this);
    details.add(facultydetails);
        
    JMenuItem studentdetails = new JMenuItem("View Student Details");
    studentdetails.setBackground(Color.WHITE);
    studentdetails.addActionListener(this);
    details.add(studentdetails);


//      -------------------Leave---------------
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);
        
        // Leave Details---
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);
        
        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);
        
        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);
        
//      ------------------Exams-------------------
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        
        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        examinationdetails.addActionListener(this);
        exam.add(examinationdetails);
        
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
        // UpdateInfo
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);
        
//      -----------------fee----------------------
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
        
//      -------------------Utility------------------
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
        
//      ---------------about----------------
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        
//      -----------exit----------------
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);




    setJMenuBar(mb);      // ! IMP --- ADD AT THE END OF THE MENUBAR ---

    
    
    
    setVisible(true);      //! ---This should be the last statement of constructor---
    }
    
    


//     ========Exception Handling=========
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")) {
            setVisible(false);


        } else if (msg.equals("Calculator")) {       //?  ----Matches according to the --exact string-- declared above
            try {
                Runtime.getRuntime().exec("calc.exe");   //opens the real app extension------
            } catch (Exception e) {
            }


        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
            }
        }
    }



public static void main (String args[]){
    new MenuBar();
    }

}