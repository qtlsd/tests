package mutiThread.findFile;
import IO.finalTest;

import java.io.File;
import java.io.File;

public class SearchFileThread extends Thread {
    private File file;
    private String res;
    public SearchFileThread(){}
    public SearchFileThread(File file,String res){
        this.file=file;
        this.res=res;
    }



    public void run(){
        String fileContent = finalTest.readFileContent(file);
        if(fileContent.contains(res)){
            System.out.println("进一次循环:");
            System.out.printf("找到子目标字符串: %s , 在文件: %s%n",res,file);
        }
    }


}
