package longest_increasing_subsequence;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-06-29-10:10
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {10,22,9,33,21,50,41,60,80};
        int longest = lengthOfLIS(nums);
        System.out.println(longest);

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            int previous = 0;
            int currentMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    previous = dp[j] + 1;
                }
                currentMax = Math.max(currentMax,previous);
            }
            dp[i] = currentMax;
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
