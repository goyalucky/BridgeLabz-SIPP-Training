package Assignments.JavaArrays.Level1;

import java.util.Scanner;

public class height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] heights = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter height of player " + (i + 1) + " in cm: ");
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        double mean = sum / n;
        System.out.println("Mean height of players: " + mean + " cm");
    }
}
