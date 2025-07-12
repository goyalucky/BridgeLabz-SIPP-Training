public class countingsort {
    public static void main(String[] args) {
        int[] ages = {14, 12, 17, 13, 16, 12, 18, 11};
        int max = 18;
        int min = 10;
        int range = max - min + 1;

        int[] count = new int[range];
        int n = ages.length;

        for (int i = 0; i < n; i++)
            count[ages[i] - min]++;

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                ages[index++] = i + min;
            }
        }

        for (int age : ages)
            System.out.print(age + " ");
    }
}
