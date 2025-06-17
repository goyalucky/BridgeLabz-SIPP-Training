package Assignments.MethodPractices.Level1;

import java.util.Scanner;

public class smallllarg3 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int smallest = Math.min(a, Math.min(b, c));
        int largest = Math.max(a, Math.max(b, c));

        System.out.println("Smallest number is: " + smallest);
        System.out.println("Largest number is: " + largest);
    }
}
