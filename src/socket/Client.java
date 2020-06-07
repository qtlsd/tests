package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //键盘输入
        Scanner sc=new Scanner(System.in);
        Thread tc = new Thread(){
            Socket s=null;

            //输入流
            InputStream is=null;
            OutputStream os=null;
            //数据流
            DataInputStream dis =null;
            DataOutputStream dos = null;

            @Override
            public void run() {
                try{
                    s = new Socket("127.0.0.1",8888);
                    is = s.getInputStream();
                    os = s.getOutputStream();
                    while(true){
                        //发送数据
                        System.out.println("输入要发送的数据：");
                        String msg1 = sc.next();
                        dos = new DataOutputStream(os);
                        dos.writeUTF(msg1);
                        //接收数据
                        dis=new DataInputStream(is);
                        String msg = dis.readUTF();
                        System.out.println("收到机器人的回话："+msg);

                        }
                        }
                catch(UnknownHostException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    if(dis!=null){
                        try{
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
        tc.start();
    }
}

