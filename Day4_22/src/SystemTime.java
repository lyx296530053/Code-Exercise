import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SystemTime {
    public static void main(String[] args) throws ParseException {
       System.out.println(System.currentTimeMillis());
        System.out.println(new Date().toString());
        System.out.println(new Date().getTime());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat();
        Date date = new Date();
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        Date date2 = simpleDateFormat.parse(format);
        System.out.println(date2);
        Calendar calendar=Calendar.getInstance(Locale.CHINA);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

    }
}
