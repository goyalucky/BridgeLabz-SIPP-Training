package JavaStringMoreproblems;

public class MostFrequentChar {
    public static void main(String[] args) {
        String str = "success";
        int[] freq = new int[256];
        for (char c : str.toCharArray()) freq[c]++;
        char maxChar = ' ';
        int max = 0;
        for (int i = 0; i < 256; i++)
            if (freq[i] > max) {
                max = freq[i];
                maxChar = (char) i;
            }
        System.out.println("Most Frequent Character: " + maxChar);
    }
}
