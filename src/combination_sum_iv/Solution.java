package combination_sum_iv;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ways = solution.combinationSum4(new int[]{3,1,2,4}, 4);
        System.out.println(ways);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
