package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//练习 引用静态方法/引用容器中的对象的方法
public class comparatorTest {
    public static void main(String[] args) {
        Random r = new Random();
        List<hero1> myList = new ArrayList<>();
        for (int i=0;i<10;i++){
            myList.add(new hero1("hero1-"+i,r.nextInt(1000),r.nextInt(100)));
        }
        //通过类引用静态方法
        //Collections.sort(myList,comparatorTest::compare);
        //通过类调用静态方法
        //Collections.sort(myList,(h1,h2)->comparatorTest.compare(h1,h2));

        //引用容器中的对象的方法
        //Collections.sort(myList,(h1,h2)->h1.compareHero(h2));
        Collections.sort(myList,hero1::compareHero);
        System.out.println(myList);

    }

    public static int compare(hero1 h1,hero1 h2){
        return h1.hp-h2.hp;
    }

}
