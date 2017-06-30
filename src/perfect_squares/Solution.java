package perfect_squares;

/**
 * @author yejinbiao
 * @create 2017-06-30-12:53
 */

public class Solution {
    public static void main(String[] args) {
        int number = numSquares(12);
        System.out.println(number);
    }

    public static int numSquares(int n) {
        //dp[i]  means number i need at least s squares to make up.
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int square = (int) Math.sqrt(i);
            int min = 2147483647;
            for (int j = 1; j <= square; j++) {
                min = Math.min(dp[i - j * j]+1,min);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
