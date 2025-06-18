package JavaString.Level2;

public class TrimSpaces {
    public static void main(String[] args) {
         String text = "   Hello Java   ";
        int start = 0, end = text.length() - 1;
        while (start <= end && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;
        String result = "";
        for (int i = start; i <= end; i++) result += text.charAt(i);
        System.out.println("Trimmed: '" + result + "'");
    }
}
