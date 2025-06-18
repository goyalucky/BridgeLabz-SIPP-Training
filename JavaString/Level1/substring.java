package Assignments.JavaString.Level1;

public class substring {
    public static void main(String[] args) {
         String s = "HelloWorld";
        String sub1 = "";
        for (int i = 0; i < 5; i++) sub1 += s.charAt(i);
        String sub2 = s.substring(0, 5);
        System.out.println(sub1.equals(sub2) ? "Equal" : "Not Equal");
    }
}
