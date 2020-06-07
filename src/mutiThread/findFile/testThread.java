package mutiThread.findFile;
import IO.finalTest;
import mutiThread.findFile.SearchFileThread;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//创建线程池解决文件查找的问题
public class testThread{
    public static void search(File folder, String search){
        ThreadPoolExecutor threadPoll = new ThreadPoolExecutor(10,15,60, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        if(folder.isFile()){
            if(folder.getName().toLowerCase().endsWith(".java")){
                threadPoll.execute(new Runnable() {
                    @Override
                    public void run() {
                        String fileContent = finalTest.readFileContent(folder);
                        if(fileContent.contains(search)){
                            System.out.println("进一次循环:");
                            System.out.printf(Thread.currentThread().getName()+ "找到子目标字符串: %s , 在文件: %s%n",search,folder);
                        }
                    }
                });
                try{
                   Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
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

    public static void main(String[] args) {
        File folder = new File("src/IO");
        search(folder,"Test");
    }
}
