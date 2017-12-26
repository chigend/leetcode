package min_cost_climbing_stairs;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {10,15,20};
        int stairs = minCostClimbingStairs(nums);
        System.out.println(stairs);
    }

    public static int minCostClimbingStairs(int[] cost) {
        //there reaching top stair means a step forward to the last stair
        //so we should define a dp array which has cost.length+1 length,where
        //dp[i] means to reach at stair i,we should pay how much.
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }
}
