package lambda;
import collection.Hero;
import lambda.hero1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//hello lambda
public class lambdaMethod {
    public static void main(String[] args) {
        Random r = new Random();
        List<hero1> myList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(new hero1("hero1-" + i, r.nextInt(1000), r.nextInt(100)));
        }
        //普通方法的筛选hero
        //filter(myList);
        //匿名类方法筛选hero
        heroCheck hc = new heroCheck() {
            @Override
            public boolean test(hero1 h) {
                return h.hp>100 && h.damage<50;
            }
        };
        //filter_lambdaClass(myList,hc);

        //lambda方式
        filter_lambdaClass(myList,h -> h.hp>100 && h.damage<50);



    }
    //普通方法的筛选hero
    public static void filter(List<hero1> mylist){
        for(hero1 h:mylist){
            if(h.hp>100 && h.damage<50){
                System.out.println(h);
            }
        }
    }

    //匿名类方法筛选hero
    public interface heroCheck{
        public boolean test(hero1 h);
    }
    public static void filter_lambdaClass(List<hero1> mylist,heroCheck c){
        for(hero1 h:mylist){
            if(c.test(h)){
                System.out.println(h);
            }
        }
    }





}
