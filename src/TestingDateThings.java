import java.util.Calendar;

public class TestingDateThings {
    public static void main(String[] args)
    {
        System.out.println("test");
        long time1 = System.currentTimeMillis();
        Calendar a = Calendar.getInstance();
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}
