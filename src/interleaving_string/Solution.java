package interleaving_string;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean interleave = solution.isInterleave("ab", "bc", "bbac");
        System.out.println(interleave);
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();
        boolean[][] dp = new boolean[chs1.length + 1][chs2.length + 1];
        dp[0][0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int k = i + j - 1;
                if (!dp[i][j]) {
                    if (i > 0 && dp[i - 1][j] && chs1[i - 1] == chs3[k]
                            || j > 0 && dp[i][j - 1] && chs2[j - 1] == chs3[k]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }
}
