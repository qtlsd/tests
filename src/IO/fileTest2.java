package IO;

import java.io.*;
import java.util.Arrays;

public class fileTest2 {
    public static void main(String[] args) {
        fileTest2 ft2 = new fileTest2();
        File srcFile = new File("E:/学习/电影/小姐姐/一小央泽/2.jpg");
        int eachSize=100*1024;
        ft2.dataSplit(srcFile,eachSize);
        ft2.dataMerge("E:/学习/电影/小姐姐/一小央泽","01.jpg");
    }

    public void dataToDoc(){
        try{
            File f = new File("d:/xyz/abc/def/lol2.txt");
            File father = f.getParentFile();
            if(father.exists()==false){
                father.mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(f);
            byte data[]={88,89};
            fos.write(data);
            fos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void dataSplit(File srcFile, int eachSize){
        //判断分成几个小文件
        int num=0;
        if(srcFile.length()%102400==0){
            num=(int)(srcFile.length()/102400);
        }
        else{
            num=(int)(srcFile.length()/102400)+1;
        }

        byte data[] = new byte[(int)srcFile.length()];
        FileInputStream fis = null;
        FileOutputStream fos =null;
        try{
            //读源文件到数组中
            fis=new FileInputStream(srcFile);
            fis.read(data);
            fis.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //对文件数遍历
        for(int i=0;i<num;i++){
            String each  = srcFile.getName().substring(0,srcFile.getName().length()-4)+"-"+i+".jpg";
            File eachFile = new File(srcFile.getParent(),each);
            byte[] eachContent;

            //计算是第几个写入
            if(i!=num-1){
                eachContent = Arrays.copyOfRange(data,eachSize*i,eachSize*(i+1));
            }
            else{
                eachContent = Arrays.copyOfRange(data,eachSize*i,data.length);
            }
            try{
                //写入每个文件
                fos=new FileOutputStream(eachFile);
                fos.write(eachContent);
                fos.close();
                System.out.println("写入的文件名为"+eachFile.getName()+"大小为："+eachFile.length());
            }
            catch (IOException e){
                e.printStackTrace();
            }finally {
                if(null!=fis){
                    try{
                        fis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
                if(null!=fos){
                    try {
                        fos.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

            }

         }

    }

    public void dataMerge(String folder, String fileName){
        try{
            File destFile = new File(folder,fileName);
            FileOutputStream fos = new FileOutputStream(destFile);
            int index=0;
            while(true){
                File eachFile = new File(folder,"2-"+index++ + ".jpg");
                if(eachFile.exists()==false){
                    break;
                }
                FileInputStream fis = new FileInputStream(eachFile);
                byte eachContent[] = new byte[(int)eachFile.length()];
                fis.read(eachContent);
                fis.close();

                fos.write(eachContent);
                fos.flush();
                System.out.printf("把子文件 %s写出到目标文件中%n",eachFile);
            }
            fos.close();
            System.out.printf("最后目标文件的大小：%,d字节" , destFile.length());
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
