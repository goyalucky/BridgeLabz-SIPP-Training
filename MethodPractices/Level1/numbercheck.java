package Assignments.MethodPractices.Level1;

import java.util.Scanner;

public class numbercheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>0){
            System.out.println("Positive");
        } else if(n==0){
            System.out.println("Zero");
        } else {
            System.out.println("Negative");
        }
    }
}
