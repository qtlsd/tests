package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileTest {
    public static void main(String[] args) {
//        File f = new File("C:/Windows");
//        File[] fs = f.listFiles();
//        long filemax = 0;
//        Long filemin=Long.MAX_VALUE;
//        for (int i = 0; i < fs.length; i++) {
//            if(fs[i].length()>filemax){
//                filemax=fs[i].length();
//            }
//            if(fs[i].length()<filemin){
//                filemin=fs[i].length();
//            }
//        }
//        String format = "最大文件的大小是%d,最小文件大小是%d";
//        System.out.printf(format,filemax,filemin);
        fileTest ft = new fileTest();
        ft.InputS();
        //ft.OutputS();
    }

    public void InputS(){
        try{
            File f =new File("lol.txt");
            FileInputStream fis = new FileInputStream(f);
            byte[] b = new byte[(int)f.length()];
            fis.read(b);
            for(byte b1:b){
                System.out.println(b1);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public void OutputS(){
        try{
            File f = new File("lol2.txt");
            FileOutputStream fos = new FileOutputStream(f);
            byte data[]={88,89};
            fos.write(data);
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
