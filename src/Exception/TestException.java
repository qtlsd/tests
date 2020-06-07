package Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {
    public static void main(String[] args) {
        TestException te = new TestException();
//        System.out.println(te.method());
//        try {
//            File i = new File("d:/LOL.exe");
//            new FileInputStream(i);
//            System.out.println("成功打开");
//        }
//        catch (FileNotFoundException e){
//            System.out.println("文件不存在");
//         e.printStackTrace();
//        }
    }

    public int method(){
        try {
            return 1;
        }
        catch (Exception e){
            return 2;
        }
        finally {
            return 3;
        }
    }
}
