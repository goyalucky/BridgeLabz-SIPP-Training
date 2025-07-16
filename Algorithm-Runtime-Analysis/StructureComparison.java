import java.util.*;

public class StructureComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        Random rand = new Random();

        for (int n : sizes) {
            int[] arr = new int[n];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < n; i++) {
                int value = rand.nextInt(n * 10);
                arr[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }

            int target = arr[rand.nextInt(n)];

            long start = System.nanoTime();
            boolean foundArray = false;
            for (int val : arr) {
                if (val == target) {
                    foundArray = true;
                    break;
                }
            }
            long end = System.nanoTime();
            System.out.println("Array Search (N=" + n + "): " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            boolean foundHash = hashSet.contains(target);
            end = System.nanoTime();
            System.out.println("HashSet Search (N=" + n + "): " + (end - start) / 1_000_000.0 + " ms");

            start = System.nanoTime();
            boolean foundTree = treeSet.contains(target);
            end = System.nanoTime();
            System.out.println("TreeSet Search (N=" + n + "): " + (end - start) / 1_000_000.0 + " ms\n");
        }
    }
}
