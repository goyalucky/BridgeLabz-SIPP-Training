package JavaStringMoreproblems;

public class ReplaceWord {
     public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replace(oldWord, newWord);
    }
    public static void main(String[] args) {
        String s = "I love Java", res = replaceWord(s, "Java", "Python");
        System.out.println(res);
    }
}
