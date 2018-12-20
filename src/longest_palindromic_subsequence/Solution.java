package longest_palindromic_subsequence;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int longest = solution.longestPalindromeSubseq("cbbd");
        System.out.println(longest);
    }

    public int longestPalindromeSubseq(String s) {
        return longestCommonSubsequence(s, new StringBuilder(s).reverse().toString());
    }

    private int longestCommonSubsequence(String a, String b) {
        char[] chsa = a.toCharArray();
        char[] chsb = b.toCharArray();
        int[][] dp = new int[chsa.length + 1][chsb.length + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }else if (chsa[i - 1] == chsb[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[chsa.length][chsb.length];
    }
}
