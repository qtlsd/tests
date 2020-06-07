package gui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import JDBC.connection;
import IO.finalTest;
import javafx.scene.effect.InnerShadow;

public class testGUI {
    //赋值文件夹-进度条-变量
    static long allFileSize = 0;
    static long curSize=0;
    public static void main(String[] args) {
        //showPic();
        //optionPanl();
        //userPwd();
        //fileOpen();
        //splitpanel();
        //eclipseTest();

        //checkEmpty();
        //checkDigit();
        //userCheck();
        //progressBar();
        //copyFilePro();
        memo();

    }
    public static JFrame frameOut(){
        //定义frame
        JFrame f = new JFrame("数字判断");
        f.setLocation(100,100);
        f.setSize(500,500);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return f;
    }
    //图片的显示与隐藏
    public static void showPic(){
        // 主窗体
        JFrame f = new JFrame("LoL");

        // 主窗体设置大小
        f.setSize(800, 600);

        // 主窗体设置位置
        f.setLocation(100, 100);

        // 主窗体中的组件设置为绝对定位
        f.setLayout(null);
        f.setResizable(false);

        JLabel l = new JLabel();
        ImageIcon i = new ImageIcon("pic/shana.png");
        l.setIcon(i);
        l.setBounds(100,100,i.getIconWidth(),i.getIconHeight());

        JButton b = new JButton("隐藏图片");
        b.setBounds(50,50,100,30);
        final boolean flag1=true;
        final boolean flag2=false;
        b.addActionListener(new ActionListener() {
            boolean flag=true;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag==true){
                    l.setVisible(false);
                    flag=flag2;
                    b.setText("显示图片");
                }else{
                    l.setVisible(true);
                    flag=flag1;
                    b.setText("隐藏图片");
                }
            }
        });


        f.setFocusable(true);
        f.add(l);
        f.add(b);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }

    //对话框实验
    public static void optionPanl(){
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(580, 240);
        f.setLayout(null);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        int option = JOptionPane.showConfirmDialog(f,"是否使用");
        System.out.println(option);
        if(JOptionPane.OK_OPTION==option){
            String ans = JOptionPane.showInputDialog(f,"请输入yes");
            if("yes".equals(ans)){
                JOptionPane.showMessageDialog(f,"禁止使用！");
            }
        }
    }

    //密码与账号
    public static void userPwd(){
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());


        JLabel u_name = new JLabel("用户名:");
        JTextArea ui_name = new JTextArea("");
        ui_name.setText("请输入用户名：");
        ui_name.setPreferredSize(new Dimension(80,30));

        JLabel p_name = new JLabel("密码：");
        JPasswordField ui_pwd = new JPasswordField("");
        ui_pwd.setText("请输入密码");

        f.add(u_name);
        f.add(ui_name);
        f.add(p_name);
        f.add(ui_pwd);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    //打开文件
    public static void fileOpen(){
        JFrame f = new JFrame("文件查找");
        f.setLayout(new FlowLayout());
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return ".txt";
            }
        });

        JButton open = new JButton("打开文件");
        JButton save = new JButton("保存文件");

        f.add(open);
        f.add(save);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250, 150);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valReturn = fc.showOpenDialog(f);
                File file = fc.getSelectedFile();
                if(valReturn==JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(f,"计划打开文件："+file.getAbsolutePath());
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valReturn = fc.showSaveDialog(f);
                File file = fc.getSelectedFile();
                if(valReturn==JFileChooser.APPROVE_OPTION){
                    JOptionPane.showMessageDialog(f,"计划保存文件："+file.getAbsolutePath());
                }
            }
        });
    }

    //splitPanel
    public static void splitpanel(){
        //创建容器
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(null);

        //创建左边的英雄选择panel
        JPanel leftp = new JPanel();
        leftp.setBounds(50,50,60,300);
        leftp.setBackground(Color.red);
        JButton b1 = new JButton("盖伦");
        JButton b2 = new JButton("提莫");
        JButton b3 = new JButton("安妮");
        leftp.add(b1);
        leftp.add(b2);
        leftp.add(b3);

        //右边的图片显示panel
        JPanel rightp = new JPanel();
        rightp.setBounds(50,200,100,300);
        rightp.setBackground(Color.blue);

        //创建图片Icon并加入label
        ImageIcon gareen = new ImageIcon("pic/gareen.jpg");
        ImageIcon teemo = new ImageIcon("pic/teemo.jpg");
        ImageIcon annie = new ImageIcon("pic/annie.jpg");
        JLabel l = new JLabel();
        l.setBounds(50,100,gareen.getIconWidth(),gareen.getIconHeight());
        l.setIcon(gareen);
        rightp.add(l);
        //声明左边button的鼠标点击事件
        b1.addActionListener(e -> l.setIcon(gareen));
        b2.addActionListener(e -> l.setIcon(teemo));
        b3.addActionListener(e -> l.setIcon(annie));

        //面板分块
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftp,rightp);
        sp.setDividerLocation(80);
        f.setContentPane(sp);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    //eclipse style
    public static void eclipseTest(){
        //创建面板
        JFrame f = new JFrame("eclipse");
        f.setLocation(200,200);
        f.setSize(1100,900);
        f.setLayout(null);

        //创建TabbedPane
        JTabbedPane tp = new JTabbedPane();
        File file =new File("src/JDBC");
        File[] fs = file.listFiles();

        //遍历java文件
        for(int i=0;i<fs.length;i++){
            //文件内容存放面板
            JPanel p = new JPanel();
            p.setBounds(50,50,900,800);
            //创建文本域
            JTextArea ta = new JTextArea();
            ta.setBounds(50,50,1000,750);
            ta.setLineWrap(true);
            JScrollPane sp = new JScrollPane(ta);


            //读取java文件
            String line=null;
            try(FileReader fr = new FileReader(fs[i]);
                BufferedReader br = new BufferedReader(fr);
            ){
                while((line=br.readLine())!=null){
                    ta.append(line+"\n");
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
               e.printStackTrace();
            }
            p.add(ta);
            tp.add(p);
        }
        //设置标签栏
        for(int i=0;i<fs.length;i++){
            ImageIcon icon1 = new ImageIcon("pic/j.png");
            tp.setIconAt(i,icon1);
            tp.setTitleAt(i,fs[i].getName());
        }

        f.setContentPane(tp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    //为空判断
    public static void checkEmpty(){
        //定义frame
        JFrame f = new JFrame("为空判断");
        f.setLocation(200,200);
        f.setSize(500,500);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //定义组件
        JTextField jf = new JTextField("");
        jf.setPreferredSize(new Dimension(50,20));
        JButton b  = new JButton("检测");
        b.setSize(50,20);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = jf.getText();
                System.out.println(res.length());
                if(res.length()==0){
                    JOptionPane.showMessageDialog(f,"文本内容为空");
                }else{
                    JOptionPane.showMessageDialog(f,"检测到文本");
                }
            }
        });
        f.add(jf);
        f.add(b);
        f.setVisible(true);
    }

    //是否为数字
    public static void checkDigit(){
        //定义frame
        JFrame f = new JFrame("数字判断");
        f.setLocation(200,200);
        f.setSize(500,500);
        f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //定义组件
        JTextField jf = new JTextField("");
        jf.setPreferredSize(new Dimension(50,20));
        JButton b  = new JButton("检测");
        b.setSize(50,20);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = jf.getText();
                char[] res1 = res.toCharArray();
                for(int i=0;i<res1.length;i++){
                    if(!Character.isDigit(res1[i])){
                        JOptionPane.showMessageDialog(f,"不是数字");
                        break;
                    }
                }
            }
        });
        f.add(jf);
        f.add(b);
        f.setVisible(true);
    }

    //账号密码验证
    public static void userCheck(){
        //定义需要的组件
        JFrame f = frameOut();
        f.setTitle("账号密码");
        JLabel j1 = new JLabel("账号：");
        JLabel j2 = new JLabel("密码");
        JTextField jt = new JTextField();
        jt.setPreferredSize(new Dimension(80,20));
        JPasswordField jp = new JPasswordField();
        jp.setPreferredSize(new Dimension(80,20));
        JButton login = new JButton("登录");
        login.setBounds(100,100,80,20);

        //定义连接和查询语句
        final Connection c= connection.connect();
        final String sqlpwd = "select * from user where name=? and password=?";

        //添加按钮监听
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入
                String user = jt.getText();
                char[] pas = jp.getPassword();
                String pwd = String.valueOf(pas);
                System.out.println(user);
                System.out.println(pwd);
                //数据库查询
                try(PreparedStatement ps = c.prepareStatement(sqlpwd);){
                    ps.setString(1,user);
                    ps.setString(2,pwd);
                    ResultSet rs = ps.executeQuery();
                    //根据查到的结果返回对话框
                    if(rs.next()){
                        System.out.println(rs.getString(1));
                        System.out.println(rs.getString(2));
                        JOptionPane.showMessageDialog(f,"登录成功");
                    }else{
                        JOptionPane.showMessageDialog(f,"账号密码错误");
                    }
                }catch (SQLException e1){
                    e1.printStackTrace();
                }
            }
        });
        f.add(j1);
        f.add(jt);
        f.add(j2);
        f.add(jp);
        f.add(login);
        f.setVisible(true);

    }

    //进度条
    public static void progressBar(){
        JFrame f = frameOut();
        JProgressBar bar = new JProgressBar();
        bar.setMaximum(100);
        bar.setStringPainted(true);
        Thread t = new Thread(){
            int value=0;
            int sleep = 100;
            @Override
            public void run() {
               while(value<=100){
                   if(value<50){
                       try{
                           Thread.sleep(sleep);
                       }catch (InterruptedException e){
                           e.printStackTrace();
                       }
                       value+=1;
                   }else{
                       sleep+=10;
                       try {
                           Thread.sleep(sleep);
                       }catch (InterruptedException e){
                           e.printStackTrace();
                       }
                       value+=1;
                   }
                   bar.setValue(value);
               }
               JOptionPane.showMessageDialog(f,"进度完成！");
            }
        };
        t.start();
        f.add(bar);
        f.setVisible(true);
    }

    //复制文件夹+进度条
    public static void copyFilePro(){
        //定义组件
        JFrame f = new JFrame("复制文件夹");
        f.setLocation(500,500);
        f.setSize(400,200);
        f.setLayout(null);

        JPanel up = new JPanel();
        up.setBounds(0,0,400,40);
        up.setLayout(new FlowLayout());
        JLabel l1 = new JLabel("源文件地址：");
        JLabel l2 = new JLabel("复制到：");
        JTextField source = new JTextField();
        source.setPreferredSize(new Dimension(80,20));
        JTextField des = new JTextField();
        des.setPreferredSize(new Dimension(80,20));
        up.add(l1);
        up.add(source);
        up.add(l2);
        up.add(des);

        JPanel low = new JPanel();
        low.setBounds(0,40,400,50);
        low.setLayout(new FlowLayout());
        JButton copy = new JButton("开始复制");
        JLabel l3 = new JLabel("文件复制进度：");
        JProgressBar bar = new JProgressBar();
        bar.setStringPainted(true);
        low.add(copy);
        low.add(l3);
        low.add(bar);


        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String srcFolder = source.getText();
                String desFolder = des.getText();
                File file = new File(srcFolder);
                calclateAllFilesize(file);
                System.out.println(allFileSize);
                new Thread(()->copyFolder(srcFolder,desFolder)).start();
                copy.setEnabled(false);
            }

            public void copyFolder(String srcFolder, String destFolder){
                File f1 = new File(srcFolder);
                File f2 = new File(destFolder);
                if(!f2.exists()){
                    f2.mkdirs();
                }

                if(f1.isDirectory()){
                    File fs[] = f1.listFiles();
                    for(File f:fs){
                        String destPath = destFolder+"/"+f.getName();
                        if(f.isDirectory()){
                            copyFolder(f.getPath(),destPath);
                        }
                        if(f.isFile()){
                            finalTest.copyFile(f.getPath(),destPath);
                            //如果是文件，就把文件大小加上当前累计大小，除以总文件大小就是进度条的百分比
                            curSize+=f.length();
                            double value = (double)curSize / (double)allFileSize;
                            int progress = (int)(value*100);
                            System.out.println(progress);
                            bar.setValue(progress);

                            if(progress==100){
                                JOptionPane.showMessageDialog(low,"复制完毕");
                            }
                        }
                    }
                }
            }


        });

        f.add(up);
        f.add(low);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    //计算总大小
    public static void calclateAllFilesize(File file) {

        if (file.isFile()) {
            allFileSize += file.length();
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                calclateAllFilesize(f);
            }
        }
    }

    //记事本
    public static void memo(){
        JFrame f = new JFrame("无标题-记事本");
        f.setSize(400,400);
        f.setLocation(200,200);

        JMenuBar mb = new JMenuBar();

        JMenu file = new JMenu("文件(F)");
        JMenu edit = new JMenu("编辑(E)");
        JMenu format = new JMenu("格式(O)");
        JMenu look = new JMenu("查看(V)");
        JMenu help = new JMenu("帮助(H)");

        file.add(new JMenuItem("新建(N)    Crtl+N"));
        file.add(new JMenuItem("打开(N)    Crtl+O"));
        file.add(new JMenuItem("保存(N)    Crtl+S"));
        file.add(new JMenuItem("另存为(A)..."));
        file.addSeparator();
        file.add(new JMenuItem("页面设置(U)..."));
        file.add(new JMenuItem("打印(P)...    Crtl+P"));
        file.addSeparator();
        file.add(new JMenuItem("退出(X)"));

        mb.add(file);
        mb.add(edit);
        mb.add(format);
        mb.add(look);
        mb.add(help);
        f.setJMenuBar(mb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
