package numberAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class StringAndRandom {
    public static void main(String[] args) {
        StringAndRandom s = new StringAndRandom();
        String target = s.randomStr(3);
        s.compare();
//        System.out.println(target);
//        System.out.println(s.buildStr("",target));


    }
    //随机生成长度字符串
    public static String randomStr(int length) {
        String res = "";
        for (int i = 0; i < length; i++) {
            int number = (int) (Math.random() * 3);
            switch (number) {
                case 0:
                    int temp = (int) (Math.random() * 10);
                    String s = String.valueOf(temp);
                    res += s;
                    break;
                case 1:
                    int tempB = (int) (Math.random() * 26 + 65);
                    char sB = (char) tempB;
                    res += Character.toString(sB);
                    break;
                case 2:
                    int tempb = (int) (Math.random() * 25 + 97);
                    char sb = (char) tempb;
                    res += Character.toString(sb);
                    break;
            }
        }
        return res;
    }

    //生成字符串并按首字母排序
    public void sortStr() {
        String[] s = new String[8];
        for (int i = 0; i < s.length; i++) {
            s[i] = randomStr(5);
        }
        System.out.println(Arrays.toString(s));
        for (int i = 0; i < s.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < s.length; j++) {
                char ci = Character.toUpperCase(s[min_index].charAt(0));
                char cj=Character.toUpperCase(s[j].charAt(0));
                if(ci>cj){
                    min_index=j;
                }
            }
            String temp = s[min_index];
            s[min_index]=s[i];
            s[i]=temp;
        }
        System.out.println(Arrays.toString(s));
    }

    //多层循环解决密码问题
    public String passWord1(){
        String pwd = randomStr(3);
        System.out.println(pwd);
        String res="";
        for(int i =0;i<pwd.length();i++){
            for(int j=48;j<=122;j++){
                if(pwd.charAt(i)==(char)j){
                    res+=Character.toString((char)j);
                }
            }
        }
        return res;
    }

    //递归解决密码问题
    public String buildStr(String res,String target){
        if(res.length()==3){
            return res;
        }
        else{
            int l = target.length();
            for(int i=48;i<=122;i++){
                if((char)i==target.charAt(0)){
                    res+=(char)i;
                }
            }
            return buildStr(res,target.substring(1,l));
        }
    }

    //单词首字母转大写
    public void toTheUp(){
        String sentence = "let there be light";
        String sentence1[] = sentence.split(" ");

        for(int i=0;i<sentence1.length;i++){
            sentence1[i]=sentence1[i].substring(0,1).toUpperCase()
                    +sentence1[i].substring(1,sentence1[i].length())
            ;
        }
        String res="";
        for(int i =0;i<sentence1.length;i++){
            res+=sentence1[i]+" ";
        }
        System.out.println(res);
    }

    //间隔大写
    public void gapUpLow(){
        String s ="lengendary";
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(i%2==0){
                char us = Character.toUpperCase(ch[i]);
                ch[i]=us;
            }
        }
        s=new String(ch);
        System.out.println(s);
    }

    //最后一个xx单词首字母大写
    public void lastUp(){
        String s ="Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        int i=s.lastIndexOf("two");
        String s1=s.substring(i,i+1).toUpperCase();
        String s2=s.substring(0,i-1);
        String s3=s.substring(i+1,s.length());
        System.out.println(s2+s1+s3);


    }

    //比较字符串
    public void compare(){
        String[] s = new String[100];
        HashSet<String> set = new HashSet<>();
        String res="";
        int n=0;
        for(int i=0;i<s.length;i++){
            s[i]=randomStr(2);
        }
        for(int i=0;i<s.length;i++){
            if(!set.contains(s[i])){
                set.add(s[i]);
            }
            else{
                res+=s[i]+" ";
                n+=1;
            }
        }
        String sentenceFormat="总共有%d种重复的字符串，\n分别是%s";
        System.out.printf(sentenceFormat,n,res);

    }
}