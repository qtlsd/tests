package JDBC;

import java.sql.*;

public class increaseID {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "insert into hero values(null,?,?,?)";
        try(
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=UTC",
                        "root", "root");
                PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                Statement st = c.createStatement();
                ){
            ps.setString(1, "盖伦");
            ps.setFloat(2, 616);
            ps.setInt(3, 100);

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int id=-1;
            if(rs.next()){
                id=rs.getInt(1);
            }
            System.out.println("插入数据的id是"+id);

            for(int i=id-1;i>0;i--){
                int targetID = i;
                ResultSet rs2 = st.executeQuery("select id from hero where id="+targetID);
                if(rs2.next()){
                    System.out.println("id=" + targetID + " 的数据存在，删除该数据");

                    String deleteSQL = "delete from hero where id = " + targetID;
                    st.execute(deleteSQL);
                    break;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
