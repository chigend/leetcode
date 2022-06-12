package fibonacci_number;

public class Solution {
    public static void main(String[] args) {
        int fib = fib(4);
        System.out.println(fib);
    }

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
