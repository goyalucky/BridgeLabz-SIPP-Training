package Assignments.MethodPractices.Level1;

import java.util.Scanner;

public class triangular {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double perimeter = a + b + c;
        double totalDistance = 5000; 

        int rounds = (int) Math.ceil(totalDistance / perimeter);

        System.out.println("The athlete must complete " + rounds + " rounds to complete 5 km.");
    }
}
