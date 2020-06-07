package JDBC;

import java.sql.*;
import java.util.Scanner;
import JDBC.connection;

public class transaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try(Connection c =connection.connect();
            Statement s = c.createStatement();)
        {

            System.out.println("连接成功");
            c.setAutoCommit(false);

            int count=0;
            int id=0;
            while(count<10){
                String sql = "select id from hero where id+"+id;
                ResultSet rs = s.executeQuery(sql);
                if(rs.next()){
                    id=rs.getInt(1);
                    String sqld = "delete from hero where id="+id;
                    s.execute(sqld);
                    count++;
                }
                id++;
            }
            String input=null;
            while(true){
                System.out.println("确定要删除前十条数据吗？ Y/N");
                input=sc.nextLine();
                if(input.equals("Y")){
                    c.commit();
                    break;
                }else if(input.equals("N")){
                    break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
