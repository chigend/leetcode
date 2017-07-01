package coin_change;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-07-01-8:57
 */

public class Solution {
    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        int minimumCoin = coinChange(coins,amount);
        System.out.print(minimumCoin);
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] > i) {
                    break;
                }
                int count = dp[i - coins[j]];
                count = count == Integer.MAX_VALUE ? Integer.MAX_VALUE : count + 1;
                min = Math.min(min,count);
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
