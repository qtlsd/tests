package numberAndString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class DateTest {
    static String strDateFormat = "yyyy.MM.dd hh:mm:ss";
    static String strDateFormat1 = "yyyy.MM.dd";
    public static void main(String[] args) {
        DateTest dt = new DateTest();
        dt.sortDate();

    }

    public void getDate(){
        String start="1995.1.1 00:00:00";
        String end="1995.12.31 23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        try {
            long date1 = sdf.parse(start).getTime();
            long date2 = sdf.parse(end).getTime();

            long r = (long)(Math.random()*(date2-date1+1)+date1);

            Date d = new Date(r);
            System.out.println(d.toString());

            String str1 = sdf.format(d);
            System.out.println(str1);

        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }

    public void sortDate(){
        Date[] dr = new Date[9];
        Date d1 = new Date(0);
        long start = d1.getTime();
        long end =0l;

        //确定随机的日期范围
        String d2 = "2000.12.31 23:59:59";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        try {
            end = sdf.parse(d2).getTime();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        long res = end-start;
        //形成数组
        for(int i=0;i<dr.length;i++){
            long temp=(long)(Math.random()*(res+1)+start);
            Date tempDate = new Date(temp);
            dr[i]=tempDate;
        }
        System.out.println(Arrays.toString(dr));

        SimpleDateFormat sdf1 = new SimpleDateFormat(strDateFormat1);
        for(int i=dr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                long head_time = 0l;
                long head_time_1 = 0l;
                long after_time = 0l;
                long after_time_1 = 0l;
                try {
                    String head = sdf1.format(dr[j]);
                    String head_1 = sdf1.format(dr[j+1]);
                    head_time = sdf1.parse(head).getTime();
                    head_time_1 = sdf1.parse(head_1).getTime();
                    after_time = dr[j].getTime()-head_time;
                    after_time_1=dr[j+1].getTime()-head_time_1;
                }
                catch (ParseException e){
                    e.printStackTrace();
                }
                if(after_time>after_time_1){
                    Date temp = dr[j];
                    dr[j]=dr[j+1];
                    dr[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(dr));

    }
}
