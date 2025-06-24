package JavaStringMoreproblems;

public class LongestWord {
    public static String LongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longest = "";
        for (String word : words)
            if (word.length() > longest.length()) longest = word;
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(LongestWord("Java programming is fun"));
    }
}
