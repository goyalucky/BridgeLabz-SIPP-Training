public class insertionsort {
    public static void main(String[] args) {
        int[] ids = {104, 101, 109, 102, 105};
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            ids[j + 1] = key;
        }

        for (int id : ids) {
            System.out.print(id + " ");
        }
    }
}
