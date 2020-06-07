package interf;

public interface AD {
    default public void attack(){
        System.out.println("攻击默认方法");
    }
}

