package Exception;

public class comprehensive1 {
    public static void main(String[] args) {
        Acount a =new Acount();
        try{
            a.deposit(20.2);
            System.out.println(a.getBalance());
            a.withdraw(30.2);
        }
        catch(OverdraftException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

class Acount{
    protected double balance;
    public Acount(){
        this.balance=0;
    }
    public Acount(double init){
        this.balance=init;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amt){
        balance+=amt;
    }
    public void withdraw(double amt) throws OverdraftException{
        if(balance-amt<=0){
            throw new OverdraftException("已透支",amt-balance);
        }
        balance=(balance-amt)>0?balance-amt:0;
    }
}

class OverdraftException extends Exception{
    private double deficit;
    public OverdraftException(String msg,double deficit){
        super(msg);
        this.deficit=deficit;
    }
    public double getDeficit(){
        return deficit;
    }
}
