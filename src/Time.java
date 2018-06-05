import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Date;
import java.util.Random;

/**
 * @Class: Time
 * @Description:
 * @Author: Jiang Chao
 * @Date: 2018/5/25
 */
public class Time {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String t1 = "1995-1-1 00:00:00";
        String t2 = "1995-12-31 23:59:59";
        try {
            Date date1 = sdf.parse(t1);
            Date date2 = sdf.parse(t2);
            System.out.println("1995年第一天： " + date1);
            System.out.println("1995年最后一天： " + date2);
            long start = date1.getTime();
            long end = date2.getTime();

            long random = (long) (Math.random() * (end-start));
            System.out.println("1995年中的随机一天： " + new Date(start+random));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
