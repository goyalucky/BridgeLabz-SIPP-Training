package Assignments.JavaArrays.Level2;

import java.util.Scanner;

public class frequency {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        if (number < 0) {
            number = -number;
        }
        long temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }
        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = (int) (temp % 10);
            temp /= 10;
        }
        int[] frequency = new int[10];
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " times.");
            }
        }
    }
}
