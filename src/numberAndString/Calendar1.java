package numberAndString;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendar1 {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        //采用单例模式获取日历对象Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        Date d1 = c.getTime();
        c.setTime(d1);
        System.out.println("今天是"+sdf.format(c.getTime()));


        c.setTime(d1);
        c.add(Calendar.MONTH,1);
        c.add(Calendar.DATE,11);
        System.out.println("下个月的倒数第三天是"+sdf.format(c.getTime()));

    }
}
