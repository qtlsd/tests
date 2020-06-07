package socket.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException {
        JFrame f = new JFrame("聊天室");
        f.setSize(500,400);
        f.setLocation(100,100);
        f.setLayout(new FlowLayout());

        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(400,300));
        ta.setLineWrap(true);
        JScrollPane sp = new JScrollPane(ta);



        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(100,20));
        JButton btn = new JButton("发送");
        p.add(tf);
        p.add(btn);

        f.add(sp);
        f.add(ta);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        ServerSocket ss = new ServerSocket(8888);
        System.out.println("listenning on port:8888");
        final Socket s =  ss.accept();

        new Thread(){
            @Override
            public void run() {
                while(true){
                    try{
                        DataInputStream dis = new DataInputStream(s.getInputStream());
                        String res=dis.readUTF();
                        ta.append(res+"\r\n");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = tf.getText();
                ta.append(text+"\r\n");
                try{
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    dos.writeUTF(text);
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        });

    }
}
