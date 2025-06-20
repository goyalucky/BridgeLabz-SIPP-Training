package Assignments.BuildinFunction.Level1;
import java.util.*;
public class MaximumOfThree {

    public static void main(String[] args) {
        int num1 = getInput("Enter first number: ");
        int num2 = getInput("Enter second number: ");
        int num3 = getInput("Enter third number: ");

        int maximum = findMaximum(num1, num2, num3);
        System.out.println("The maximum of the three numbers is: " + maximum);
    }

    static int getInput(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextInt();
    }

    static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
}