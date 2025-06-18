package JavaString.Level2;

public class SplitWords {
    public static void main(String[] args) {
          String text = "Hello World from Java";
        String[] manualSplit = text.split(" ");
        for (String w : manualSplit) System.out.println(w);
    }
}
