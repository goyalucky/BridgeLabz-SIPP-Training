package Assignments.ControlFlows.Level3;

import java.util.Scanner;

public class leapyearandor {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (year >= 1582) {
            if ( (year % 400 == 0) || ( (year % 4 == 0) && (year % 100 != 0) ) ) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is not a Leap Year.");
            }
        } else {
            System.out.println("Year must be greater than or equal to 1582 (Gregorian calendar).");
        }
    }
}
