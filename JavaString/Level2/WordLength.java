package JavaString.Level2;

public class WordLength {
    public static void main(String[] args) {
          String text = "Hello World Java";
        String[] words = text.split(" ");
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(words[i].length());
        }
        for (String[] row : result) System.out.println(row[0] + " " + row[1]);
    }
}
