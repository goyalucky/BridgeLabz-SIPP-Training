package Assignments.BuildinFunction.Level1;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add  2. Subtract  3. Multiply  4. Divide");
        System.out.print("Choose operation (1-4): ");
        int choice = sc.nextInt();

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        switch (choice) {
            case 1 -> System.out.println("Result: " + add(a, b));
            case 2 -> System.out.println("Result: " + subtract(a, b));
            case 3 -> System.out.println("Result: " + multiply(a, b));
            case 4 -> {
                if (b == 0) System.out.println("Cannot divide by zero.");
                else System.out.println("Result: " + divide(a, b));
            }
            default -> System.out.println("Invalid operation.");
        }
    }

    static double add(double x, double y) {
        return x + y;
    }

    static double subtract(double x, double y) {
        return x - y;
    }

    static double multiply(double x, double y) {
        return x * y;
    }

    static double divide(double x, double y) {
        return x / y;
    }
}
