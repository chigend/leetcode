package longest_increasing_subsequence;

/**
 * @author yejinbiao
 * @create 2017-06-29-10:10
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int longest = lengthOfLIS(nums);
        System.out.println(longest);

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = dp[j] + 1;
                }
                dp[i] = Math.max(dp[i],max);
            }
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
