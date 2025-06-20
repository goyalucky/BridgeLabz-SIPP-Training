package Assignments.BuildinFunction.Level1;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        String text = getInput();
        if (isPalindrome(text))
            System.out.println("It's a palindrome.");
        else
            System.out.println("Not a palindrome.");
    }

    static String getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
