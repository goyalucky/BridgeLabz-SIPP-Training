package JavaStringMoreproblems;

public class Substring {
    public static int countOccurrences(String str, String subStr) {
        int count = 0, i = 0;
        while ((i = str.indexOf(subStr, i)) != -1) {
            count++; i += subStr.length();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOccurrences("abcabcabc", "abc"));
    }
}
