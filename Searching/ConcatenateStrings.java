public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java"};
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }

        System.out.println(sb.toString());
    }
}
