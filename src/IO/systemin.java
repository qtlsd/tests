package IO;

import java.io.*;
import java.util.Scanner;

public class systemin {
    public static void main(String[] args) {
        String className;
        String property;
        String propertyName;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入类名：");
        className = sc.nextLine();
        System.out.println("请输入属性类型：");
        property = sc.nextLine();
        System.out.println("请输入属性名：");
        propertyName = sc.nextLine();

        File f1 = new File("garen.txt");
        File f2 = new File("exchange.java");
        String str1 = null;
        StringBuffer sb = new StringBuffer(100);

        try(
                FileReader fr = new FileReader(f1);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(f2);
                BufferedWriter bw = new BufferedWriter(fw);
                ){
            while((str1=br.readLine())!=null){
                sb.append(str1).append("\n");
            }
            //替换模板中的关键字
            String newStr = sb.toString();
            System.out.println(newStr);
            newStr=newStr.replaceAll("@class@", className);
            newStr = newStr.replaceAll("@type@", property);
            newStr = newStr.replaceAll("@property@", propertyName);

            newStr = newStr.replaceAll("@Uproperty@", Character.toUpperCase(propertyName.charAt(0))+propertyName.substring(1));

            System.out.println("替换后的内容:");
            System.out.println(newStr);

            bw.write(newStr);

            System.out.println("文件保存在："+f2.getAbsolutePath());
        }catch (IOException e){

        }
    }
}
