package Assignments.JavaString.Level1;

public class LowerCaseDemo {
    public static void main(String[] args) {
          String s = "HELLO", l1 = "", l2 = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) l1 += (char)(s.charAt(i) + 32);
        System.out.println(l1.equals(l2) ? "Equal" : "Not Equal");
    }
}
