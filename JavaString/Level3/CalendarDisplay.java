package JavaString.Level3;

import java.util.GregorianCalendar;
import java.util.*;

public class CalendarDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt(), year = sc.nextInt();
        Calendar cal = new GregorianCalendar(year, month - 1, 1);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 1; i < cal.get(Calendar.DAY_OF_WEEK); i++) System.out.print("    ");
        for (int i = 1; i <= days; i++) {
            System.out.printf("%3d ", i);
            if ((i + cal.get(Calendar.DAY_OF_WEEK) - 1) % 7 == 0) System.out.println();
        }
    }
}
