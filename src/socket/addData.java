package socket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import JDBC.connection;

public class addData {
    public static void main(String[] args) {
        Connection c = connection.connect();
        HashMap<String,String> dic = new HashMap<>();
        dic.put("你好","你好!");
        dic.put("你叫什么","你是机器人小黑");
        dic.put("今天天气如何？","那可太热了！");
        dic.put("再见","慢走不送！");
        String sql = "insert into dictionary values(null,?,?)";
        try(PreparedStatement ps = c.prepareStatement(sql);){
            for(Map.Entry<String,String> entry:dic.entrySet()){
                String s1 = entry.getKey();
                String s2 = entry.getValue();
                ps.setString(1,s1);
                ps.setString(2,s2);
                ps.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
