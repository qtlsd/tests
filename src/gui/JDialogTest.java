package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogTest {
    public static void main(String[] args) {
        //设置外部窗体
        JFrame f = new JFrame("外部窗体");
        f.setSize(800, 600);
        f.setLocation(100, 100);
        f.setLayout(null);

        //设置按钮
        JButton b = new JButton("打开一个模态窗口");
        b.setBounds(100,100,180,20);
        f.add(b);

        JDialog j = new JDialog(f);
        j.setBounds(400,300,400,300);
        j.setResizable(false);
        j.setModal(true);
        j.setTitle("打开一个模态窗口");

        JButton j1 = new JButton("解锁大小");
        j1.setBounds(50,50,80,30);
        j1.setLayout(null);
        j.add(j1);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.setVisible(true);
            }
        });

        j1.addActionListener(new ActionListener() {
            boolean flag = false;
            @Override
            public void actionPerformed(ActionEvent e) {
               if(flag==false){
                   j.setResizable(true);
                   j1.setText("锁定大小");
                   flag=true;
               }else{
                   j.setResizable(false);
                   j1.setText("解锁大小");
                   flag=false;
               }
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}
