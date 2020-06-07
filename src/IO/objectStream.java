package IO;
import IO.hero;

import java.io.*;

public class objectStream {
    public static void main(String[] args) {
        hero h = new hero();
        h.name="波提";
        h.hp=100;

        File f = new File("garen.txt");
        try(
                //创建输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                //创建输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            oos.writeObject(h);
            hero h2 = (hero)ois.readObject();
            System.out.println(h2.name);
            System.out.println(h2.hp);
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
