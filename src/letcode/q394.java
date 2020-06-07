package letcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class q394 {
    public static void main(String[] args) {
        System.out.println(-5%7);

    }
    public static String decodeString(String s) {
        String temp="";
        int num=0;
        Deque<ArrayList> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num+=ch-'0';
            }
            else if(Character.toString(ch).equals("[")){
                ArrayList l1 =new ArrayList();
                l1.add(temp);
                l1.add(num);
                System.out.println(l1.toString());
                stack.push(l1);
                temp="";
                num=0;
            }
            else if(Character.toString(ch).equals("]")){
                ArrayList l_temp = stack.pop();
                System.out.println(l_temp);
                StringBuffer sb =new StringBuffer("");
                for(int k=0;k<(int)l_temp.get(1);k++){
                    sb.append(temp);
                }
                temp = (String) l_temp.get(0)+sb.toString();
            }
            else{
                temp+=ch;
            }
        }
        return temp;
    }
}
