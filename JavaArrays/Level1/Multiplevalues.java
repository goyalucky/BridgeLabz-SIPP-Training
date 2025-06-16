package Assignments.JavaArrays.Level1;

import java.util.Scanner;

public class Multiplevalues {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int[] numbers = new int[10];
        int sum = 0, count = 0;
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            if (num <= 0) break;
            numbers[count++] = num;
            sum += num;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("Sum of numbers: " + sum);
    }
}
