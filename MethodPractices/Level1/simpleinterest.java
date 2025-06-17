package Assignments.MethodPractices.Level1;

import java.util.Scanner;

public class simpleinterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();
        int si = (p*r*t)/100;
        System.out.println(si);
    }
}
