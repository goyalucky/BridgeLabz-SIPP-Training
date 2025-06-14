package Assignments.ControlFlows.Level3;

import java.util.Scanner;

public class marks {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        double physics = sc.nextDouble();
        double chemistry = sc.nextDouble();
        double maths = sc.nextDouble();
        double total = physics + chemistry + maths;
        double percentage = (total / 300) * 100;

        System.out.println("Average Percentage: " + percentage + "%");
        String grade, remarks;

        if (percentage >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Level 2, below but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
