package interf;

abstract class Animal {
    public static void main(String[] args) {
        Spider sp = new Spider();
        sp.eat();

        Cat c =new Cat();
        c.setName("加菲");
        String catName = c.getName();
        System.out.println(catName);
        c.play();
        c.eat();

        Fish f =new Fish();
        f.setName("金鱼");
        String fishName = f.getName();
        System.out.println(fishName);
        f.play();
        f.eat();


    }
    protected int legs;
    protected Animal(){}
    protected Animal(int legs){
        this.legs = legs;
    }
    public abstract void eat();
    public void walk(){
        System.out.println(legs);
    }
}

class Spider extends Animal{
    public Spider(){
        super(8);
    }
    public void eat(){
        System.out.println("蜘蛛用蛛网捕食");
    }
}

interface Pet{
    public void setName(String name);
    public String getName();
    public void play();

}

class Cat extends Animal implements Pet{
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void eat(){
        System.out.println("猫吃个鱼");
    }
    public void play(){
        System.out.println("猫玩个球");
    }
    public Cat(String name){
        super(4);
        this.name=name;
    }
    public Cat(){
        this.name="";
    }
}

class Fish extends Animal implements Pet{
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Fish(){}
    public void walk(){
        System.out.println("鱼没有腿，不能走路");
    }
    public void eat(){
        System.out.println("鱼吃饵");
    }
    public void play(){
        System.out.println("鱼欢水");
    }
}