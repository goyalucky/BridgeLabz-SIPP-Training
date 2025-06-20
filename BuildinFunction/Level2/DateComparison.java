package Assignments.BuildinFunction.Level2;

import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate d1 = LocalDate.parse(sc.next());
        LocalDate d2 = LocalDate.parse(sc.next());
        if(d1.isBefore(d2)) System.out.println("First date is before second.");
        else if(d1.isAfter(d2)) System.out.println("First date is after second.");
        else System.out.println("Both dates are equal.");
    }
}
