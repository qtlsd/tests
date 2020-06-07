package collection;

import java.util.*;
import collection.Hero;



public class TestGeneric {
    public static void iterate(ArrayList<? extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }

//    public static void iterateAP(ArrayList<APHero> list) {
//        for (Hero hero : list) {
//            System.out.println(hero.name);
//        }
//    }
//
//    public static void iterateAD(ArrayList<ADHero> list) {
//        for (Hero hero : list) {
//            System.out.println(hero.name);
//        }
//    }

    public static void main(String[] args) {

    }
}


