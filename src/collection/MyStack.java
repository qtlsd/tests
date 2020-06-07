package collection;
import interf.Stack;

import java.util.LinkedList;
import collection.Hero;

public class MyStack implements Stack {
    protected static LinkedList<Hero> myList = new LinkedList<>();
    public static void main(String[] args) {
        MyStack ms = new MyStack();
       ms.push(new Hero("Hero1"));
        ms.push(new Hero("Hero2"));
        ms.push(new Hero("Hero3"));
        System.out.println(ms.peek().name);
        System.out.println(ms.pull().name);
        for(Hero h:myList){
            System.out.println(h.name);
        }
    }
    ////把英雄推入到最后位置
    @Override
    public synchronized void push(Hero h) {
        myList.addLast(h);
    }

    ////查看最后一个英雄
    @Override
    public Hero peek() {
        Hero h = myList.getLast();
        return h;
    }

    //把最后一个英雄取出来
    @Override
    public synchronized Hero pull() {
        Hero h = myList.removeLast();
        return h;
    }
}
