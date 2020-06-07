package collection;

public class Hero {
    public String name;
    public int hp;
    public int damage;
    public Hero(){}
    public Hero(String name){
        this.name=name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void attackHero(Hero h2) {
        System.out.println(this.name+ " 正在攻击 " + h2.getName());
    }
}
