package numberAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class box {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] cs = s.toCharArray();
        ArrayList<Character> ar = new ArrayList();
        for(int i =0;i<cs.length;i++){
            if(Character.isDigit(cs[i]) || Character.isUpperCase(cs[i])){
                ar.add(cs[i]);
            }
        }
        System.out.println(ar);


    }

}
