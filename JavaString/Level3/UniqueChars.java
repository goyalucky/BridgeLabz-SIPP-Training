package JavaString.Level3;

public class UniqueChars {
    public static void main(String[] args) {
          String text = "hello";
        String unique = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (unique.indexOf(c) == -1) unique += c;
        }
        System.out.println("Unique: " + unique);
    }
}
