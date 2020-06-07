package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import JDBC.connection;

public class Server {
    public static List<String> cannotUnderstand = new ArrayList<>();
    public static void main(String[] args) {
        cannotUnderstand.add("听求不懂啊");
        cannotUnderstand.add("对不起，我无法回答您的问题");
        cannotUnderstand.add("再说一遍？");
        cannotUnderstand.add("大声点");
        cannotUnderstand.add("一边玩儿去");


        Thread ts = new Thread(){
            ServerSocket ss=null;
            Socket s=null;
            //输入流
            InputStream is=null;
            OutputStream os=null;
            //数据流
            DataInputStream dis =null;
            DataOutputStream dos = null;
            //键盘输入
            Scanner sc=new Scanner(System.in);
            //数据库连接
            Connection c = connection.connect();
            String sql = "select * from dictionary where receive = ?";
            @Override
            public void run() {
                try(PreparedStatement ps = c.prepareStatement(sql);){
                    ss = new ServerSocket(8888);
                    System.out.println("监听在端口号:8888");
                    s =ss.accept();
                    is = s.getInputStream();
                    os = s.getOutputStream();
                    while(true){
                        //接收数据
                        dis = new DataInputStream(is);
                        dos = new DataOutputStream(os);
                        String msg=dis.readUTF();
                        if(msg.equals("bye")){
                            System.out.println("结束会话");
                            break;
                        }
                        System.out.println("收到数据："+msg);

                        //查找数据库中是存在
                        ps.setString(1,msg);
                        ps.execute();
                        ResultSet rs = ps.getResultSet();
                        String res=null;
                        //如果存在则进行对应回答
                        if(rs.next()){
                            res = rs.getString(3);
                        }
                        //不存在则随机答复
                        else{
                            Collections.shuffle(cannotUnderstand);
                            res=cannotUnderstand.get(0);
                        }
                        System.out.println("机器人的回复"+res);
                        dos.writeUTF(res);
                    }
                    is.close();
                    os.close();
                    ss.close();
                    }catch(IOException e){
                    e.printStackTrace();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                finally {
                    if(dis!=null){
                        try {
                            dis.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if(dos!=null){
                        try{
                            dos.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        ts.start();

    }
}
