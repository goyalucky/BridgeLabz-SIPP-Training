package JavaString.Level3;

public class FirstNonRepeat {
    public static void main(String[] args) {
        String text = "swiss";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (text.indexOf(c) == text.lastIndexOf(c)) {
                System.out.println("First non-repeating: " + c);
                break;
            }
        }
    }
}
