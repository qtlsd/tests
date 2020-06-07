package IO;

import java.io.*;
import java.nio.Buffer;

public class finalTest {
    public static void main(String[] args) {
        //copyFile("lol2.txt","lol3.txt");
        //copyFolder("xyz","dest");
        File folder = new File("src/IO");
        search(folder,"Test");
    }

    //复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile
    public static void copyFile(String srcFile, String destFile){
        File f = new File(srcFile);
        File f1 = new File(destFile);
        String line=null;

        try(FileReader fr = new FileReader(f);
            FileWriter fw = new FileWriter(f1);
            BufferedReader br = new BufferedReader(fr);
            PrintWriter pw = new PrintWriter(fw);
                ){
            while((line=br.readLine())!=null){
                pw.write(line+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //复制文件夹,实现如下方法，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)
    public static void copyFolder(String srcFolder, String destFolder){
        File f1 = new File(srcFolder);
        File f2 = new File(destFolder);
        if(!f2.exists()){
            f2.mkdirs();
        }

        if(f1.isDirectory()){
            File fs[] = f1.listFiles();
            for(File f:fs){
                String destPath = destFolder+"/"+f.getName();
                if(f.isDirectory()){
                    copyFolder(f.getPath(),destPath);
                }
                if(f.isFile()){
                    copyFile(f.getPath(),destPath);
                }
            }
        }
    }

    //查找文件内容
    public static void search(File folder, String search){
        if(folder.isFile()){
            if(folder.getName().toLowerCase().endsWith(".java")){
                String fileContent = readFileContent(folder);
                if(fileContent.contains(search)){
                    System.out.println("进一次循环:");
                    System.out.printf("找到子目标字符串: %s , 在文件: %s%n",search,folder);
                }
            }
        }
        if(folder.isDirectory()){
            File[] f =folder.listFiles();
            for(File fn:f){
                search(fn,search);
            }
        }
    }
    //查找文件内容__读取文件内容的函数
    public static String readFileContent(File file) {
        InputStreamReader fsr = null;
        try{
            fsr=new InputStreamReader(new FileInputStream(file),"UTF-8");
            char res[] = new char[(int)file.length()];
            fsr.read(res);
            return new String(res);
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }finally {
            if(fsr!=null){
                try{
                    fsr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    }
