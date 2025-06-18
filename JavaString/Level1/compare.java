package Assignments.JavaString.Level1;

import java.util.Scanner;

public class compare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine(), s2 = sc.nextLine();
        boolean isEqual = s1.length() == s2.length();
        for (int i = 0; i < s1.length() && isEqual; i++)
            if (s1.charAt(i) != s2.charAt(i)) isEqual = false;
        System.out.println("charAt(): " + (isEqual ? "Equal" : "Not Equal"));
        System.out.println("equals(): " + (s1.equals(s2) ? "Equal" : "Not Equal"));
    }
}
