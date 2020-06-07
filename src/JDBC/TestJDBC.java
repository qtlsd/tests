package JDBC;


import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) {
        String sql = "select * from hero";
        String sql1 = "insert into hero values(null,?,?,?)";
        String sqlpwd = "select * from user where name=? and password=?";
        //execute(sqlpwd);
        list(0,5);
    }

    public static void execute(String sql){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "root");
            Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql);
        )
        {
            System.out.println("连接成功");
            //增
//            int n = 100;
//            for(int i=0;i<n;i++){
//                String temp = "insert into hero values(null,concat('英雄',"+i+"),500,30)";
//                s.execute(temp);
//            }
            //删
            //String sql = "delete from hero where id=5";

            String name = "wch1";
            String password = "pwd";

            ps.setString(1,name);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("查询到了");
            }else{
                System.out.println("没查询到");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //分页查询
    public static void list(int start, int count){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "select * from hero limit ?,?";
        String sql1 = String.format("select * from hero limit %d,%d",start,count);

        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC",
                "root", "root");
            Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql);
        )
        {
            System.out.println("连接成功");
            //preStatement方式
//            ps.setInt(1,start);
//            ps.setInt(2,count);
//            ResultSet rs = ps.executeQuery();

            //execute方式
            s.execute(sql1);
            ResultSet rs = s.getResultSet();
            while(rs.next()){
                int id=rs.getInt(1);
                String name = rs.getString(2);
                int hp = rs.getInt(3);
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%d\t%d\t\n", id,name,hp,damage);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
