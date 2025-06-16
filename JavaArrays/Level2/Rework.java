package Assignments.JavaArrays.Level2;

import java.util.Scanner;

public class Rework {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        while (num > 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] newDigits = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    newDigits[i] = digits[i];
                }
                digits = newDigits;
            }

            digits[index] = (int) (num % 10);
            num /= 10;
            index++;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        System.out.print("Digits in the number: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println("\nLargest digit: " + largest);
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second largest digit not found.");
        } else {
            System.out.println("Second largest digit: " + secondLargest);
        }
    }
}
