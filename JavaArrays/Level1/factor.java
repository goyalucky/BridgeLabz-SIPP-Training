package Assignments.JavaArrays.Level1;

import java.util.Scanner;

public class factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find its factors: ");
        int num = sc.nextInt();

        int[] factors = new int[num];
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                factors[count++] = i;
        }

        System.out.print("Factors of " + num + ": ");
        for (int i = 0; i < count; i++)
            System.out.print(factors[i] + " ");
    }
}
