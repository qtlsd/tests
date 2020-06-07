package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
    public static Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection c=null;
        try{c= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "root");
            Statement s = c.createStatement();
            //PreparedStatement ps = c.prepareStatement();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }
}
