package Assignments.JavaString.Level1;

public class UpperCaseDemo {
    public static void main(String[] args) {
        String s = "hello", u1 = "", u2 = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) u1 += (char)(s.charAt(i) - 32);
        System.out.println(u1.equals(u2) ? "Equal" : "Not Equal");
    }
}
