package Assignments.JavaArrays.Level1;

import java.util.Scanner;

public class multiplication6to9 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (num >= 6 && num <= 9) {
            System.out.println("Multiplication table of " + num + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }
        } else {
            System.out.println("Invalid number. Please enter a number between 6 and 9.");
        }
    }
}
