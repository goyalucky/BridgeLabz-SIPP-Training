package JavaString.Level2;

public class MinMaxWord {
    public static void main(String[] args) {
         String text = "Java is a powerful language";
        String[] words = text.split(" ");
        String shortest = words[0], longest = words[0];
        for (String w : words) {
            if (w.length() < shortest.length()) shortest = w;
            if (w.length() > longest.length()) longest = w;
        }
        System.out.println("Shortest: " + shortest);
        System.out.println("Longest: " + longest);
    }
}
