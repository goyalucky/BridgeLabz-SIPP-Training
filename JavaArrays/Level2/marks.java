package Assignments.JavaArrays.Level2;

import java.util.Scanner;

public class marks {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        double[][] marks = new double[number][3];
        double[] percentages = new double[number];
        String[] grades = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter marks for student " + (i + 1) + " (out of 100):");

            for (int j = 0; j < 3; j++) {
                String subject = "";
                if (j == 0) subject = "Physics";
                else if (j == 1) subject = "Chemistry";
                else if (j == 2) subject = "Maths";

                do {
                    System.out.print(subject + " marks: ");
                    marks[i][j] = sc.nextDouble();
                    if (marks[i][j] < 0 || marks[i][j] > 100) {
                        System.out.println("Marks should be between 0 and 100. Please re-enter.");
                    }
                } while (marks[i][j] < 0 || marks[i][j] > 100);
            }

            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (total / 300) * 100;

            if (percentages[i] >= 90) {
                grades[i] = "A";
            } else if (percentages[i] >= 80) {
                grades[i] = "B";
            } else if (percentages[i] >= 70) {
                grades[i] = "C";
            } else if (percentages[i] >= 60) {
                grades[i] = "D";
            } else {
                grades[i] = "F";
            }
        }
        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics Marks: " + marks[i][0]);
            System.out.println("Chemistry Marks: " + marks[i][1]);
            System.out.println("Maths Marks: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentages[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }
    }
}
