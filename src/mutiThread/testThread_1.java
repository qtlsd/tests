package mutiThread;

//波动充能
public class testThread_1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            int i=0;
            public void run(){
                while(true){
                    for(int i=1;i<=3;i++){
                        try{
                            Thread.sleep(1000);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        System.out.println("波动拳第"+i+"发");
                    }
                    System.out.println("开始5秒充能");
                    try{
                        Thread.sleep(5000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
    }
}
