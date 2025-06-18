package Assignments.JavaString.Level1;

public class IllegalArgument {
    public static void main(String[] args) {
        test(-5);   
    }
     public static void test(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative not allowed");
    }
}
