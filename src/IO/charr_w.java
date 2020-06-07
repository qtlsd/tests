package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class charr_w {
    public static void main(String[] args) {
        File encodingFile = new File("lol2.txt");
        File encodedFile = new File("encodeRes.txt");
        File decodedFile = new File("encodeRes.txt2");
        encodeFile(encodingFile,encodedFile);
        decodeFile(encodedFile,decodedFile);

    }
    public static void encodeFile(File encodingFile, File encodedFile){
        FileReader fr=null;
        FileWriter fw=null;
        try{
            fr=new FileReader(encodingFile);
            char[] fileData = new char[(int)encodingFile.length()];
            fr.read(fileData);
            for(int i=0;i<fileData.length;i++){
                fileData[i]=encode(fileData[i]);
            }
            System.out.println(Arrays.toString(fileData));
             fw=new FileWriter(encodedFile);
            fw.write(fileData);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void decodeFile(File decodingFile, File decodedFile){
        FileReader fr=null;
        FileWriter fw=null;
        try{
            fr=new FileReader(decodingFile);
            char[] fileData = new char[(int)decodingFile.length()];
            fr.read(fileData);
            for(int i=0;i<fileData.length;i++){
                fileData[i]=decode(fileData[i]);
            }
            System.out.println(Arrays.toString(fileData));
            fw=new FileWriter(decodedFile);
            fw.write(fileData);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fr!=null){
                try {
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(fw!=null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static char encode(char a){
        char c=a;
        if(a>=48&&a<57 || a>=65&&a<90|| a>=97&&a<122){
            c=(char)(a+1);
        }
        else if(a==122||a==90){
            c = (char)(a-25);
        }else if(a==57){
            c = (char)(a-9);
        }
        return c;
    }
    public static char decode(char a){
        char c=a;
        if(a>48&&a<=57 || a>65&&a<=90|| a>97&&a<=122){
            c=(char)(a-1);
        }
        else if(a==65||a==97){
            c = (char)(a+25);
        }else if(a==48){
            c = (char)(a+9);
        }
        return c;
    }
}
