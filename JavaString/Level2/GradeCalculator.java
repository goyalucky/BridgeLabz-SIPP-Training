package JavaString.Level2;

import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt(), c = sc.nextInt(), m = sc.nextInt();
        double per = (p + c + m) / 3.0;
        String grade = per >= 80 ? "A" : per >= 70 ? "B" : per >= 60 ? "C" : per >= 50 ? "D" : per >= 40 ? "E" : "R";
        System.out.println("Percentage: " + per);
        System.out.println("Grade: " + grade);

    }
}
