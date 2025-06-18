package JavaString.Level3;

public class CharFrequency {
    public static void main(String[] args) {
          String text = "hello";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int count = 0;
            for (int j = 0; j < text.length(); j++)
                if (text.charAt(j) == c) count++;
            System.out.println(c + " : " + count);
        }
    }
}
