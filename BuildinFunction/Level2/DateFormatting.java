package Assignments.BuildinFunction.Level2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy")));
    }
}
