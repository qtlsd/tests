package lambda;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class helloLambda {
    public static void main(String[] args) {
        Random r = new Random();
        List<hero1> myList = new ArrayList<>();
        for (int i=0;i<10;i++){
            myList.add(new hero1("hero1-"+i,r.nextInt(1000),r.nextInt(100)));
        }


        Collections.sort(myList,(o1, o2)->(int)(o1.hp-o2.hp));
        System.out.println(myList.toString());
    }
}

class hero1{
    String name;
    int hp;
    int damage;
    public hero1(){}
    public hero1(String name,int hp,int damage){
        this.name=name;
        this.hp=hp;
        this.damage=damage;
    }

    public String toString(){
        return "name:"+name+" hp:"+hp+" damage:"+damage;
    }

    //3.引用容器中的对象的方法
    public boolean matched(){
        return this.hp>100&&this.damage<50;
    }

    public int compareHero(hero1 h2){
        return this.hp-h2.hp;
    }
}