package Assignments.ControlFlows.Level3;

import java.util.Scanner;

public class armstrong {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int numDigits = 0;
        int temp = number;
        while (temp != 0) {
            numDigits++;
            temp /= 10;
        }
        int sum = 0;
        temp = number;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is NOT an Armstrong number.");
        }
    }
}
