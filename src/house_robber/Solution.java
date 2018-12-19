package house_robber;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int maxRob = solution.rob(new int[]{});
        System.out.println(maxRob);
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}
