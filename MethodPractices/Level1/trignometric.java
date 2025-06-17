package Assignments.MethodPractices.Level1;

import java.util.Scanner;

public class trignometric {
     public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        double[] results = new double[3];

        results[0] = Math.sin(radians);
        results[1] = Math.cos(radians);
        results[2] = Math.tan(radians);

        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double angle = sc.nextDouble();

        double[] trigValues = calculateTrigonometricFunctions(angle);

        System.out.printf("sin(%.2f°) = %.4f\n", angle, trigValues[0]);
        System.out.printf("cos(%.2f°) = %.4f\n", angle, trigValues[1]);
        System.out.printf("tan(%.2f°) = %.4f\n", angle, trigValues[2]);
 }
}