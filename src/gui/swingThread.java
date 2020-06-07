package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import IO.finalTest;


public class swingThread {
    static int totalFile = 0;
    public static void main(String[] args) {
        //actionTest();
        //swingworker();
        findFILE();
    }
    public static class testFrame extends JFrame {
        public testFrame(){
            setTitle("test");

            setSize(400,400);
            setLocation(100,100);
            setLayout(null);

            JButton b = new JButton("立即执行！");
            b.setBounds(50,50,200,30);
            add(b);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            System.out.println("当前线程是否是 事件调度线程: " + SwingUtilities.isEventDispatchThread());
        }
    }

    //时间调度线程
    public static void actionTest(){
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 200);
        f.setLayout(null);

        final JLabel l = new JLabel();

        ImageIcon i = new ImageIcon("e:pic/shana.png");
        l.setIcon(i);
        l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(150, 200, 100, 30);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setVisible(false);

                System.out.println("当前使用的是事件调度线程：" + SwingUtilities.isEventDispatchThread());
            }
        });

        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }

    //长耗时任务线程SwingWorker和时间调度线程
    public static void swingworker(){
        JFrame f = new JFrame("LoL");
        f.setSize(300, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        JButton b1 = new JButton("在事件调度线程中执行长耗时任务");
        JButton b2 = new JButton("使用SwingWorker执行长耗时任务");
        JLabel l = new JLabel("任务执行结果");
        f.add(b1);
        f.add(b2);
        f.add(l);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l.setText("开始执行完毕");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                l.setText("任务执行完毕");
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>(){
                    @Override
                    protected Void doInBackground() throws Exception {
                        System.out.println("执行这个SwingWorder的线程是：" + Thread.currentThread().getName());
                        l.setText("开始执行完毕");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        l.setText("任务执行完毕");
                        return null;
                    }
                };
                worker.execute();
            }
        });
        f.setVisible(true);



    }

    //查找文件-长耗时
    public static void findFILE(){
        JFrame f = new JFrame("LoL");
        f.setSize(600, 200);
        f.setLocation(200, 100);
        f.setLayout(new FlowLayout());

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        JLabel l = new JLabel("请输入需要查找的文件夹：");
        JTextField text = new JTextField();
        text.setPreferredSize(new Dimension(80,20));

        JLabel l1 = new JLabel("请输入关键字：");
        JTextField text1 = new JTextField();
        text1.setPreferredSize(new Dimension(80,20));
        p.add(l);
        p.add(text);
        p.add(l1);
        p.add(text1);

        JButton btn = new JButton("搜索");
        btn.setPreferredSize(new Dimension(100,30));
        f.add(p);
        f.add(btn);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setText("正在搜索");
                btn.setEnabled(false);
                String target = text.getText();
                File folder = new File(target);
                String fileContent = text1.getText();

                SwingWorker<Void,Void> worker = new SwingWorker<Void,Void>() {

                    @Override
                    protected Void doInBackground() throws Exception {
                        search(folder,fileContent);
                        JOptionPane.showMessageDialog(f,"找到满足条件的文件："+totalFile);
                        return null;
                    }
                };
                worker.execute();
            }
            //查找文件内容
            public void search(File folder, String search){
                if(folder.isFile()){
                    if(folder.getName().toLowerCase().endsWith(".java")){
                        String fileContent = finalTest.readFileContent(folder);
                        if(fileContent.contains(search)){
                            totalFile+=1;
                            System.out.println("进一次循环:");
                            System.out.printf("找到子目标字符串: %s , 在文件: %s%n",search,folder);
                        }
                    }
                }
                if(folder.isDirectory()){
                    File[] f =folder.listFiles();
                    for(File fn:f){
                        search(fn,search);
                    }
                }
            }
        });


    }
}


