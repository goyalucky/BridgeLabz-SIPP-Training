package Assignments.JavaString.Level1;

public class tochararray {
    public static void main(String[] args) {
         String s = "Hello";
        char[] a = getChars(s), b = s.toCharArray();
        boolean flag = true;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) flag = false;
        System.out.println(flag ? "Equal" : "Not Equal");
    }
     public static char[] getChars(String s) {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) c[i] = s.charAt(i);
        return c;
    }
}
