package lambda;
import lambda.hero1;
import lambda.lambdaMethod.heroCheck;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

//方法引用
public class lambdaMethod2 {
    public static void main(String[] args) {
        Random r = new Random();
        List<hero1> mylist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mylist.add(new hero1("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }

        heroCheck hc = new heroCheck() {
            @Override
            public boolean test(hero1 h) {
                return h.hp>100&&h.damage<50;
            }
        };

        //1.1 在Lambda表达式中使用静态方法
        //filter(mylist,h -> lambdaMethod2.testHero(h));
        //1.2直接引用静态方法
        //filter(mylist,lambdaMethod2::testHero);

        //2.1 使用类的对象方法
        lambdaMethod2 test_l = new lambdaMethod2();
        //filter(mylist,lambdaMethod2::testHero);

        //3.1 调用容器中的对象Hero的方法matched
        filter(mylist,h -> h.matched());
        //3.2 进一步改写为(引用构造器)
        filter(mylist,hero1::matched);


    }

    public  static void filter(List<hero1> mylist,heroCheck c){
        for(hero1 h:mylist){
            if(c.test(h)){
                System.out.println(h);
            }
        }
    }

    //1.引用静态方法
    public static boolean testHero(hero1 h){
        return h.hp>100&&h.damage<50;
    }

}
