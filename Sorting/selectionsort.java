public class selectionsort {
    public static void main(String[] args) {
        int[] scores = {78, 92, 65, 88, 70};
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[min])
                    min = j;
            }
            int temp = scores[min];
            scores[min] = scores[i];
            scores[i] = temp;
        }

        for (int score : scores)
            System.out.print(score + " ");
    }
}
