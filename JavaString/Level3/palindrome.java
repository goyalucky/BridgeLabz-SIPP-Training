package JavaString.Level3;

public class palindrome {
    public static void main(String[] args) {
        String text = "madam";
        String rev = "";
        for (int i = text.length() - 1; i >= 0; i--) rev += text.charAt(i);
        System.out.println(text.equals(rev) ? "Palindrome" : "Not Palindrome");
    }
}
