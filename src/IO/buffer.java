package IO;

import java.io.*;

public class buffer {
    public static void main(String[] args) {
        write();
        read();
    }

    public void bufferAndRead(){
        File f = new File("lol2.txt");
        try(
                FileWriter fr = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fr);
        ){
            bw.write("31@35");

        }catch (IOException e){
            e.printStackTrace();
        }
        try(FileReader fd = new FileReader(f);
            BufferedReader br = new BufferedReader(fd);
        ){
            String line = br.readLine();
            String[] s = line.split("@");
            for(int i=0;i<s.length;i++){
                System.out.println(Integer.parseInt(s[i]));
            }
        }catch (IOException e){

        }
    }
    private static void write() {
        File f =new File("d:/lol.txt");
        try (
                FileOutputStream fos  = new FileOutputStream(f);
                DataOutputStream dos =new DataOutputStream(fos);
        ){
            dos.writeInt(300);
            dos.writeInt(20);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static void read() {
        File f =new File("d:/lol.txt");
        try (
                FileInputStream fis  = new FileInputStream(f);
                DataInputStream dis =new DataInputStream(fis);
        ){
            System.out.printf("%d %d", dis.readInt(), dis.readInt());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
