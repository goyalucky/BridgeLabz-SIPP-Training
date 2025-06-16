package Assignments.JavaArrays.Level2;

import java.util.Scanner;

public class youngest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ageAmar = sc.nextInt();
        int heightAmar = sc.nextInt();
        int ageAkbar = sc.nextInt();
        int heightAkbar = sc.nextInt();
        int ageAnthony = sc.nextInt();
        int heightAnthony = sc.nextInt();
        String youngest;
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            youngest = "Amar";
        } else if (ageAkbar < ageAmar && ageAkbar < ageAnthony) {
            youngest = "Akbar";
        } else if (ageAnthony < ageAmar && ageAnthony < ageAkbar) {
            youngest = "Anthony";
        } else {
            youngest = "There is a tie for youngest age.";
        }
        String tallest;
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            tallest = "Amar";
        } else if (heightAkbar > heightAmar && heightAkbar > heightAnthony) {
            tallest = "Akbar";
        } else if (heightAnthony > heightAmar && heightAnthony > heightAkbar) {
            tallest = "Anthony";
        } else {
            tallest = "There is a tie for tallest height.";
        }
        System.out.println("\nThe youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);
    }
}
