package decode_ways;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.numDecodings("01");
        System.out.println(count);
    }

    public  int numDecodings(String s) {
        char[] chs = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = chs[0] == '0' ? 0 : 1;
        for (int i = 1; i < chs.length; i++) {
            int digit = chs[i] - '0';
            int tens = chs[i - 1] - '0';
            dp[i] += digit == 0 ? 0 : dp[i - 1];
            int combine = tens * 10 + digit;
            if (combine <= 26 && combine > 9) {
                dp[i] += i == 1 ? 1 : dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }

}
