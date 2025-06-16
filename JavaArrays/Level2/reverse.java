package Assignments.JavaArrays.Level2;

import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long temp = num;
        int count = 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        int[] digits = new int[count];
        temp = num;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = (int) (temp % 10);
            temp /= 10;
        }
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }
    }
}
