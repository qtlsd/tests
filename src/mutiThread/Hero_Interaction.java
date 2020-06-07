package mutiThread;

//线程交互
public class Hero_Interaction {
    public static void main(String[] args) {
        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        for(int i=0;i<2;i++){
            new recoverHero(gareen).start();
        }
        for(int i=0;i<5;i++){
            new hurtHero(gareen).start();
        }
    }
}
class recoverHero extends Thread{
    private Hero hero;
    public recoverHero(Hero hero){
        this.hero=hero;
    }

    @Override
    public void run() {
        while (true){
            hero.recover();
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class hurtHero extends Thread{
    private Hero hero;
    public hurtHero(Hero hero){
        this.hero=hero;
    }
    @Override
    public void run() {
        while (true){
            hero.hurt();
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}