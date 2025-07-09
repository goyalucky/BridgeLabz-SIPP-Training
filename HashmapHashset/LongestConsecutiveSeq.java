import java.util.HashSet;

public class LongestConsecutiveSeq {
     public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int maxLen = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currNum = num;
                int length = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    length++;
                }
                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
