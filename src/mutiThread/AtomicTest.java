package mutiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    private static int value = 0;
    private static AtomicInteger atomicValue =new AtomicInteger();

    public static void main(String[] args) {
        int number = 100000;
        Thread[] s1 = new Thread[number];
        for(int i=0;i<s1.length;i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    value++;
                }
            };
            t.start();
            s1[i]=t;
        }

        for(Thread t:s1){
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行value++后，value的值变成:%d%n", number,value);

        Thread[] s2 = new Thread[number];
        for(int i=0;i<s2.length;i++){
            Thread t = new Thread(){
                @Override
                public void run() {
                    atomicValue.incrementAndGet();
                }
            };
            t.start();
            s2[i]=t;
        }

        for(Thread t:s2){
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("%d个线程进行atomicValue.incrementAndGet();后，atomicValue的值变成:%d%n", number,atomicValue.intValue());

    }
}
