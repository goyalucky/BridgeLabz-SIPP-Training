package Assignments.MethodPractices.Level1;

import java.util.Scanner;

public class quotient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1= sc.nextInt();
        int n2= sc.nextInt();
        int quotient = n1/n2;
        int remainder = n1%n2;
        System.out.println("Quotient is: "+quotient);
        System.out.println("Remainder is: "+remainder);
    }
}
