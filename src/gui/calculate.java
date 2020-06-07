package gui;

import javax.swing.*;
import java.awt.*;

public class calculate {
    public static void main(String[] args) {
        JFrame f = new JFrame("计算器");
        f.setSize(500,400);
        f.setLocation(200,200);
        f.setLayout(new GridLayout(4,5,8,8));

        String[] arr = {"7","8","9","/","sq","4","5","6","*","%","1","2","3","-","1/x","0","+/-",".","+","="};
        for(int i=0;i<arr.length;i++){
            JButton b = new JButton(arr[i]);
            b.setPreferredSize(new Dimension(40,40));
            f.add(b);
        }

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
