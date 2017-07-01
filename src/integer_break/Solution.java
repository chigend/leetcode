package integer_break;

/**
 * @author yejinbiao
 * @create 2017-06-30-13:32
 */

public class Solution {
    public static void main(String[] args) {
        int i = integerBreak(3);
        System.out.println(i);
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n+1];

        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; i - j > 1; j++) {
                max = Math.max(max,(i - j) * j);
                max = Math.max(max,dp[i-j] * j);
            }
            dp[i] = max;
        }
        return dp[n];

    }
}
