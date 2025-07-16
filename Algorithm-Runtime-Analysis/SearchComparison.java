import java.util.*;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int n : sizes) {
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = rand.nextInt(n * 10);
            }

            int target = data[rand.nextInt(n)];

            long start = System.nanoTime();
            linearSearch(data, target);
            long end = System.nanoTime();
            System.out.println("Linear Search for N = " + n + ": " + (end - start) / 1_000_000.0 + " ms");

            Arrays.sort(data);
            start = System.nanoTime();
            binarySearch(data, target);
            end = System.nanoTime();
            System.out.println("Binary Search for N = " + n + ": " + (end - start) / 1_000_000.0 + " ms\n");
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
