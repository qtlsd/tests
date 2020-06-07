package interf;

public interface Mortal {
    default public void attack(){
        System.out.println("魔法默认方法");
    }
}
