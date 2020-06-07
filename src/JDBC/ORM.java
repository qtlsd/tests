package JDBC;
import IO.hero;
import mutiThread.Hero;


import javax.sql.ConnectionPoolDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ORM {
    static Connection c = connection.connect();
    public static void main(String[] args) {


    }

    public static Hero get(int id){
        Hero hero = null;
        String query="select * from hero where id = " + id;
        try( Statement s = c.createStatement();){
            s.execute(query);
            ResultSet rs = s.getResultSet();
            if(rs.next()){
                hero = new Hero();
                String name = rs.getString(2);
                int hp = rs.getInt("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
                System.out.println("取出id=" + id + "的数据,它的name是:"+name);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hero;
    }

    //把一个Hero对象插入到数据库中
    public static void add(Hero h){
        String name = h.name;
        int hp=h.hp;
        int damage=h.damage;

        String insertSql="insert into hero values(null,?,?,?)";

        try(PreparedStatement ps = c.prepareStatement(insertSql);){
            ps.setString(1,name);
            ps.setInt(2,hp);
            ps.setInt(3,damage);
            ps.execute();
            System.out.printf("新增对象%s",name);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //把这个Hero对象对应的数据删除掉
    public static void delete(Hero h){
        int id=h.id;

        String delSql="delete from hero where id="+id;
        try(Statement s = c.createStatement();) {
            s.execute(delSql);
            System.out.println("删除对象"+h.name);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //更新这条Hero对象
    public static void update(Hero h){
        String upsql = "update hero set name = ? , hp = ? , damage = ? where id = ?";
        try(PreparedStatement ps = c.prepareStatement(upsql);){
            ps.setString(1,h.name);
            ps.setInt(2,h.hp);
            ps.setInt(3,h.damage);
            ps.setInt(4,h.id);
            ps.execute();
            System.out.println("把名字改为" + h.name + "并且更新到数据库");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Hero> list() {
        List<Hero> l = new ArrayList<>();
        try(Statement s = c.createStatement();){
            String searchsql = "select * from hero";
            ResultSet rs = s.executeQuery(searchsql);

            while(rs.next()){
                Hero h = new Hero();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int hp = rs.getInt(3);
                int damage=rs.getInt(4);

                h.id=id;
                h.name=name;
                h.hp=hp;
                h.damage=damage;
                l.add(h);
            }
            System.out.println("数据库一共有" + l.size() + "条数据");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return l;
    }
}
