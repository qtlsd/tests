package test1;

import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        //hw.gold();
        //hw.waterFlower();
        //hw.Primary();
        //hw.twoSort();

        String s="anvc";
        System.out.println(Integer.parseInt(s));

    }

    public void gold(){
        double max_n = Double.POSITIVE_INFINITY;
        double res=0;
        double golden=0.618;
        int fenzi=0;
        int fenmu=0;

        for(int a=1;a<=20;a++){
            for(int b=1;b<=20;b++){
                if(a%2==0 & b%2==0)
                    continue;
                res=(float)a/b-golden;
                double new1 = Math.abs(res);
                if(new1<max_n){
                    max_n=new1;
                    fenzi=a;
                    fenmu=b;
                }

            }
        }
        System.out.println(fenzi+" "+fenmu+" "+max_n);
    }

    public void waterFlower(){
        for(int baseNumber = 100;baseNumber<=999;baseNumber++){
            int b = baseNumber;
            int res=0;
            while(b>=1){
                int temp=b%10;
                res+=Math.pow(temp,3);
                b=(int)b/10;
            }
            if(res==baseNumber)
                System.out.println(baseNumber);
        }
    }

    public void Primary(){
        for(int a=1;a<=8;a++){
            int b=8-a;
            int c =14-a;
            int d=c-6;
            if(b+d==10){
                System.out.println(a+" "+b+" "+c+" "+d);
            }
        }
    }

    public void twoSort(){
        int[] a =new int[5];
        for (int i=0;i<a.length;i++){
            a[i]=(int)(Math.random()*100);
        }
        System.out.println(Arrays.toString(a));
        //选择排序
        for(int i=0;i<a.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[minIndex]){
                    minIndex=j;
                }
            }
            int temp=a[minIndex];
            a[minIndex]=a[i];
            a[i]=temp;
        }
        System.out.println(Arrays.toString(a));
        //冒泡排序
        for(int i=a.length-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if (a[j]<a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
