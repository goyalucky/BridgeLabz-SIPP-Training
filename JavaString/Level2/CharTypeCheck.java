package JavaString.Level2;

public class CharTypeCheck {
    public static void main(String[] args) {
        String text = "Hello 123!";
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                if ("aeiouAEIOU".indexOf(c) != -1)
                    System.out.println(c + " : Vowel");
                else
                    System.out.println(c + " : Consonant");
            } else {
                System.out.println(c + " : Not a Letter");
            }
        }
    }
}
