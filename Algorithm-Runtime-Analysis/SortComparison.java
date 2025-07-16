import java.util.*;

public class SortComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int n : sizes) {
            int[] original = new int[n];
            for (int i = 0; i < n; i++) original[i] = rand.nextInt(n * 10);

            int[] bubbleData = Arrays.copyOf(original, n);
            int[] mergeData = Arrays.copyOf(original, n);
            int[] quickData = Arrays.copyOf(original, n);

            if (n <= 10000) {
                long start = System.nanoTime();
                bubbleSort(bubbleData);
                long end = System.nanoTime();
                System.out.println("Bubble Sort for N = " + n + ": " + (end - start) / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort for N = " + n + ": Unfeasible");
            }

            long start = System.nanoTime();
            mergeSort(mergeData, 0, n - 1);
            long end = System.nanoTime();
            System.out.println("Merge Sort for N = " + n + ": " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            quickSort(quickData, 0, n - 1);
            end = System.nanoTime();
            System.out.println("Quick Sort for N = " + n + ": " + (end - start) / 1_000_000.0 + " ms\n");
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
