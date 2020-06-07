package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    List<Connection> cs = new ArrayList<Connection>();
    int size;

    public ConnectionPool(int size){
        this.size=size;
        init();
    }

    public void init(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            for(int i=0;i<size;i++){
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC",
                        "root", "root");
                cs.add(c);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //获得一个连接
    public synchronized Connection getConnection(){
        while(cs.isEmpty()){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Connection c =cs.remove(0);
        return c;
    }

    //使用结束归还
    public synchronized void returnConnection(Connection c){
        cs.add(c);
        this.notify();
    }

}
