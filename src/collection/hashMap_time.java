package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class hashMap_time {
    public static void main(String[] args) {
        List<Hero> myList = new ArrayList<>();
        for(int i=0;i<3000000;i++){
            int r = (int)((Math.random()*9000)+1000);
            Hero h = new Hero("hero-"+r);
            myList.add(h);
        }

        long start = System.currentTimeMillis();
        hashMapTest(myList);
        long end = System.currentTimeMillis();
        System.out.println("hashMap一共用时："+(end-start)+"ms");

        long start1 = System.currentTimeMillis();
        no_hashMap(myList);
        long end1 = System.currentTimeMillis();
        System.out.println("no_hashMap一共用时："+(end1-start1)+"ms");

        }
    public static void hashMapTest(List<Hero> myList){
        HashMap<String,List<Hero>> heroMap = new HashMap<>();
        for(Hero h:myList){
            List<Hero> hero_l = heroMap.get(h.name);
            if(null==hero_l){
                hero_l = new ArrayList<>();
                heroMap.put(h.name,hero_l);
            }
            hero_l.add(h);
        }
        System.out.println(heroMap.get("hero-5555"));
    }
    public static void no_hashMap(List<Hero> myList){
        List<Hero> hero_l2 = new ArrayList<>();
        for(int i=0;i<myList.size();i++){
            if(myList.get(i).name.equals("hero-5555")){
                hero_l2.add(myList.get(i));
            }
        }
        System.out.println(hero_l2);
    }

    }


