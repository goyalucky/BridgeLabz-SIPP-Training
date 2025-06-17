package Assignments.MethodPractices.Level 2;

import java.util.Scanner;

public class Natural {
    public static int sumRecursive(int n) {
        if (n == 1)
            return 1;
        else
            return n + sumRecursive(n - 1);
    }
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Natural Number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input! Please enter a natural number (positive integer).");
            return;
        }

        int recursiveSum = sumRecursive(n);
        int formulaSum = sumFormula(n);

        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula  : " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("Both computations are correct and results match.");
        } else {
            System.out.println("There is a mismatch in the results.");
        }
    }
}
