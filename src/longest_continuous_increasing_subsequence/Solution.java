package longest_continuous_increasing_subsequence;

public class Solution {
    public static void main(String[] args) {
        int max = findLengthOfLCIS(new int[]{1,3,5,4,7});
        System.out.println(max);
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = 1;
        int countLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                countLen++;
                max = Math.max(max, countLen);
            }else {
                countLen = 1;
            }
        }
        return max;
    }
}
