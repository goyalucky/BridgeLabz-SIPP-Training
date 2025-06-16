package Assignments.JavaArrays.Level2;

import java.util.Scanner;

public class employee {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);

        final int ec = 10;
        double[] s = new double[ec];
        double[] yearsOfService = new double[ec];
        double[] bonus = new double[ec];
        double[] newSalary = new double[ec];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        for (int i = 0; i < ec; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Enter Salary (positive number): ");
            s[i] = sc.nextDouble();
            if (s[i] <= 0) {
                System.out.println("Invalid s. Please enter again.");
                i--;
                continue;
            }
            System.out.print("Enter Years of Service (positive number): ");
            yearsOfService[i] = sc.nextDouble();
            if (yearsOfService[i] < 0) {
                System.out.println("Invalid years of service. Please enter again.");
                i--;
                continue;
            }
        }
        for (int i = 0; i < ec; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = s[i] * 0.05;
            } else {
                bonus[i] = s[i] * 0.02;
            }

            newSalary[i] = s[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += s[i];
            totalNewSalary += newSalary[i];
        }
        System.out.println("\nEmployee Details:");
        System.out.printf("%-10s %-12s %-12s %-12s\n", "Employee", "Old Salary", "Bonus", "New Salary");
        for (int i = 0; i < ec; i++) {
            System.out.printf("%-10d %-12.2f %-12.2f %-12.2f\n", (i + 1), s[i], bonus[i], newSalary[i]);
        }
        System.out.println("\nTotal Old Salary of all employees: ₹" + String.format("%.2f", totalOldSalary));
        System.out.println("Total Bonus payout: ₹" + String.format("%.2f", totalBonus));
        System.out.println("Total New Salary of all employees: ₹" + String.format("%.2f", totalNewSalary));
    }
}
