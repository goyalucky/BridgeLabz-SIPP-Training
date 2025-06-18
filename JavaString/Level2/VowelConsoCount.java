package JavaString.Level2;

public class VowelConsoCount {
    public static void main(String[] args) {
         String text = "Hello Java";
        int vowels = 0, consonants = 0;
        text = text.toLowerCase();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
