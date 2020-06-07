package mutiThread;
import numberAndString.StringAndRandom;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//字符串解码
public class testThread_2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new decode());
        t1.start();

        Thread t2 = new Thread(new log_thread());
        t2.start();

    }
}

class decode implements Runnable{
    String pwd = String.valueOf(random(3));
    static List<String> container = new ArrayList<>();

    public char[] random(int index){
        char[] res = new char[3];
        for(int i=0;i<res.length;i++){
            res[i] = (char)(Math.random()*48+64);
        }
        return res;
    }
    @Override
    public void run() {
        System.out.println("本次的密码是"+pwd);
        boolean cnt=true;
        while (true){
            String test = String.valueOf(random(3));
            if (test.equals(pwd)){
                System.out.println("密码匹配正确"+pwd);
                container.add(test);
                break;
            }else{
                container.add(test);
            }
        }
    }
}

class log_thread implements Runnable{
    @Override
    public void run() {
        while (true){
                if(decode.container.size()<=0){
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else{
                    for(int i=0;i<decode.container.size();i++) {
                        System.out.println("当前匹配的密码是" + decode.container.remove(0));
                    }
                }

        }
    }
}

