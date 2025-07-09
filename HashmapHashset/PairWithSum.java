import java.util.HashSet;

public class PairWithSum {
     public static boolean hasPair(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 1, 3};
        int target = 10;
        System.out.println(hasPair(arr, target));
    }
}
