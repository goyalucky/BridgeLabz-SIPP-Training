package Assignments.ControlFlows.Level2;

import java.util.Scanner;

public class youngest {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + names[i] + ": ");
            heights[i] = sc.nextInt();
        }

        int youngestIndex = 0, tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex])
                youngestIndex = i;
            if (heights[i] > heights[tallestIndex])
                tallestIndex = i;
        }

        System.out.println("Youngest: " + names[youngestIndex]);
        System.out.println("Tallest: " + names[tallestIndex]);
    }
}
