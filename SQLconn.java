package PROJECTS;

import java.sql.*;

public class SQLconn {

    Connection c;     //--- Interface---Part of java.sql package
    Statement s;     //  ----interface --helps to execute sql statements

    SQLconn(){  
        try{                            // As sql dataBase is not in teh project, it can give exception(try-catch is used)


            Class.forName("com.mysql.cj.jdbc.Driver");  //------- 1 - REGISTERING THE DRIVER CLASS ------------


            c = DriverManager.getConnection("jdbc:mysql:///UNIVERSITYMANAGEMENTSYSTEM", "root", "root");
                                                            //----------- 2 - CREATING CONNECTION STRING ------------------


            s=c.createStatement();                       //------------ 3 - CREATING STATEMENT--------------


        }catch (Exception a ){
            a.printStackTrace();        //prints the exception
        }
    }
}
