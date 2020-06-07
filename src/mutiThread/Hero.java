package mutiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class Hero {
    public int id;
    public String name;
    public int hp ;
    public int damage;

    public synchronized void recover(){
       if(hp>=1000){
           try{
               this.wait();
           }catch (InterruptedException e){
               e.printStackTrace();
           }
       }
        hp+=1;
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了
        this.notify();
    }

    public synchronized void hurt(){
        while (hp<=1){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        hp-=1;
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }

    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public boolean isDead() {
        return 0>=hp?true:false;
    }
}
