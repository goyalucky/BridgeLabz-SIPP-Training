package Assignments.BuildinFunction.Level1;

import java.util.Scanner;

public class GCD_LCM {
    public static void main(String[] args) {
        int a = getInput("Enter first number: ");
        int b = getInput("Enter second number: ");
        int gcd = findGCD(a, b);
        int lcm = findLCM(a, b, gcd);
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    static int getInput(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextInt();
    }

    static int findGCD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static int findLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
