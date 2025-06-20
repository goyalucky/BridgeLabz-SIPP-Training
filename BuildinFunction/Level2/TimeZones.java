package Assignments.BuildinFunction.Level2;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZones {
    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now(ZoneId.of("GMT")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
        System.out.println(ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
    }
}
