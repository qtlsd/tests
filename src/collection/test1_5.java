package collection;

import java.util.*;

import collection.Hero;

//遍历ArrayList
public class test1_5 {
    public static void main(String[] args) {
        ArrayList<Hero> myHero = new ArrayList<>();
        for(int i=0;i<100;i++){
            myHero.add(new Hero("hero "+i));
        }
        //for1(myHero);
        //iterator1(myHero);

    }
    public static void for1(List<Hero> myHero){
        for(int i=myHero.size()-1;i>=0;i--){
            String index[] = myHero.get(i).name.split(" ");
            int j = Integer.parseInt(index[1]);
            if(j%8==0){
                myHero.remove(j);
            }
        }
        for(Hero h:myHero){
            System.out.println(h.name);
        }

    }

    public static void iterator1(List<Hero> myHero){
        Iterator<Hero> it = myHero.iterator();
        while(it.hasNext()){
            String name = it.next().getName().substring("hero ".length());
            int idx = Integer.parseInt(name);
            if(idx%8==0){
                it.remove();
            }
        }
        for (Iterator<Hero> iterator = myHero.iterator(); iterator.hasNext();) {
            Hero hero = (Hero) iterator.next();
            System.out.println(hero.name);
        }

    }
}
