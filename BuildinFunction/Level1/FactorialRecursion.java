package Assignments.BuildinFunction.Level1;

import java.util.Scanner;

public class FactorialRecursion {
    public static void main(String[] args) {
        int n = getInput();
        long fact = factorial(n);
        System.out.println("Factorial of " + n + " is " + fact);
    }

    static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    static long factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }
}
