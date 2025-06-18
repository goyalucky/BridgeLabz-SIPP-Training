package JavaString.Level3;

import java.util.Scanner;

public class BMIStatus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            double h = sc.nextDouble(), w = sc.nextDouble();
            double bmi = w / (h * h);
            String status = bmi <= 18.4 ? "Underweight" : bmi <= 24.9 ? "Normal" : bmi <= 39.9 ? "Overweight" : "Obese";
            System.out.println("Height: " + h + " Weight: " + w + " BMI: " + bmi + " Status: " + status);
        }
    }
}
