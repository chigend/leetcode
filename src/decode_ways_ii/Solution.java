package decode_ways_ii;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ways = solution.numDecodings("********************");
        System.out.println(ways);
    }

    public int numDecodings(String s) {
        long[] dp = new long[s.length()];
        int mod = 1000000007;
        char[] chs = s.toCharArray();
        dp[0] = chs[0] == '0' ? 0 : (chs[0] == '*' ? 9 : 1);
        for (int i = 1; i < chs.length; i++) {
            char c = chs[i];
            boolean matchAll = c == '*';
            if (c != '0'){
                dp[i] = dp[i - 1] % mod * (matchAll ? 9 : 1);
            }
            int[] tens = chs[i - 1] == '*' ? new int[]{1,2} : new int[]{chs[i - 1] - '0'};
            for (int j = 0; j < tens.length; j++) {
                long base = i == 1 ? 1 : dp[i - 2] % mod;
                dp[i] %= mod;
                if (tens[j] == 1) {
                    dp[i] += base * (matchAll ? 9 : 1);
                }else if (tens[j] == 2) {
                    dp[i] += base * (matchAll ? 6 : (c > '6') ? 0 : 1);
                }
            }
        }
        return (int)(dp[chs.length - 1] % mod);
    }
}
