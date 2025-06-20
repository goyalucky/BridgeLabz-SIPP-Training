package Assignments.BuildinFunction.Level1;

import java.util.Scanner;

public class FibonacciSequence {
    public static void main(String[] args) {
        int n = getInput();
        generateFibonacci(n);
    }

    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        return sc.nextInt();
    }

    static void generateFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
