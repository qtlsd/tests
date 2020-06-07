package gui;

import JDBC.ORM;
import mutiThread.Hero;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tableGUI {
    public static void main(String[] args) {
        JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());


        //创建一个TableModel
        HeroTableModel htm= new HeroTableModel();

        //根据 TableModel来创建 Table
        JTable t = new JTable(htm);
        t.getColumnModel().getColumn(0).setPreferredWidth(10);
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        t.getSelectionModel().setSelectionInterval(0,0);

        JScrollPane sp = new JScrollPane(t);

        JPanel p = new JPanel();
        final JLabel lName = new JLabel("名称");
        final JTextField tfName = new JTextField("");
        final JLabel lHp = new JLabel("血量");
        final JTextField tfHp = new JTextField("");
        JButton bAdd = new JButton("增加");
        tfName.setPreferredSize(new Dimension(80, 30));
        tfHp.setPreferredSize(new Dimension(80, 30));

        p.add(lName);
        p.add(tfName);
        p.add(lHp);
        p.add(tfHp);
        p.add(bAdd);

        bAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ORM orm = new ORM();
                Hero h = new Hero();

                String name = tfName.getText();
                String hp = tfHp.getText().trim();

                if(name.length()==0){
                    JOptionPane.showMessageDialog(f,"名称不能为空！");
                    tfName.grabFocus();
                    return;
                }

                try{
                    Integer.parseInt(hp);
                }catch (NumberFormatException e1){
                    JOptionPane.showMessageDialog(f,"血量得是数字啊！");
                    e1.printStackTrace();
                    tfHp.grabFocus();
                    return;
                }



                h.name = name;
                h.hp = Integer.parseInt(hp);


                orm.add(h);
                htm.heros = orm.list();
                t.updateUI();
            }
        });


        f.add(p,BorderLayout.NORTH);
        f.add(sp, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}
