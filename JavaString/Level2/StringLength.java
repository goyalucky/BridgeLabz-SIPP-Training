package JavaString.Level2;
public class StringLength {
    public static void main(String[] args) {
        String text = "Hello World";
        int length = 0;
        for (char c : text.toCharArray()) length++;
        System.out.println("Length: " + length);
    }
}
