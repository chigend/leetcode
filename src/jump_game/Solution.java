package jump_game;

/**
 * @author yejinbiao
 * @create 2017-07-01-18:12
 */

public class Solution {
    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] - nums[i - 1] == 1) {
                continue;
            }
            if (dp[i]) {
                int num = nums[i];
                if (i + num >= nums.length - 1) return true;
                for (int j = 1; j <= nums[i]; j++) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[nums.length-1];
    }
}
