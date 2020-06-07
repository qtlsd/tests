package mutiThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//死锁实验
//用lock解决死锁
public class deadLock {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Lock lock_a = new ReentrantLock();
        Lock lock_b = new ReentrantLock();

        Condition ca = lock_a.newCondition();
        Condition cb = lock_b.newCondition();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                boolean aIsLock = false;
                boolean bIsLock = false;

                try{
                    //t1试图占有a
                    aIsLock=lock_a.tryLock(10,TimeUnit.SECONDS);
                    if(aIsLock){
                        System.out.println("t1成功占有a");
                        //停1000秒让t2有足够时间占有b
                        Thread.sleep(1000);
                        System.out.println("t1试图占有b");
                        try{
                            bIsLock=lock_b.tryLock(10,TimeUnit.SECONDS);
                            if(bIsLock){
                                System.out.println("t1成功占用b，开始啪啪啪");
                            }else{
                                System.out.println("t1一直占用不了b，准备放弃");
                            }
                        }finally {
                            if(bIsLock){
                                System.out.println("t1 释放b");
                                lock_b.unlock();
                            }
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if(aIsLock){
                        System.out.println("t1 释放a");
                        lock_a.unlock();
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                boolean aIsLock = false;
                boolean bIsLock = false;
                    //t2试图占用b
                    try {
                        bIsLock=lock_b.tryLock(10,TimeUnit.SECONDS);
                        if(bIsLock){
                            System.out.println("t2成功占用b");
                            //停1000秒让t1有足够时间占有a
                            Thread.sleep(1000);
                            System.out.println("t2试图在10s占用a");
                        }
                        try{
                            aIsLock=lock_a.tryLock(10,TimeUnit.SECONDS);
                            if(aIsLock){
                                System.out.println("t2占用a成功，开始啪啪啪");
                            }else{
                                System.out.println("t1一直占用不了b，准备放弃");
                            }
                        }finally {
                            if(aIsLock){
                                System.out.println("t2 准备释放a");
                                lock_a.unlock();
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        if(bIsLock){
                            System.out.println("t2 准备释放b");
                            lock_b.unlock();
                        }
                    }

            }
        };
        t2.start();

    }
}
