package numberAndString;
import numberAndString.StringAndRandom;
import numberAndString.MyStringBuffer;

public class stringBuf {
    public static void main(String[] args) {
        String res="";
        StringAndRandom sar = new StringAndRandom();
        MyStringBuffer mb = new MyStringBuffer(res);
        long start = System.currentTimeMillis();
        for(int i=0;i<=1000000;i++){
            try{
                String temp =sar.randomStr(10);
                mb.append(temp);
            }
            catch (Exception e){
                System.out.println("出现异常");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("MyStringBuffer的方式一共消耗了："+(end-start)+"ms");


        long start1 = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<=1000000;i++){
            StringBuffer temp = new StringBuffer(sar.randomStr(10));
            sb.append(temp);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("StringBuffer的方式一共消耗了："+(end1-start1)+"ms");
    }
}
