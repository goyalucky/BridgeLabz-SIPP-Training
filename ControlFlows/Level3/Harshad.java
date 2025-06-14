package Assignments.ControlFlows.Level3;

import java.util.Scanner;

public class Harshad {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int temp = number;
        int sumOfDigits = 0;

        while (temp != 0) {
            int digit = temp % 10;
            sumOfDigits += digit;
            temp /= 10;
        }
        if (number % sumOfDigits == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is NOT a Harshad Number.");
        }
    }
}
