package minimum_ascii_delete_sum_for_two_strings;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int minimumDeletion = solution.minimumDeleteSum("lkhgf", "zxc");
        System.out.println(minimumDeletion);
    }

    public int minimumDeleteSum(String s1, String s2) {
        /**
         * use dp[i][j] to represent minimum  ascii deletion to make s1.substring(0, i) and s2.substring(0, j);
         * so there comes the transition,
         *             { 0  if(i = 0 and j = 0) means to make ""(s1.substring(0,0)) and ""(s2.substring(0,0)) equal, there is no need to delete
         * transition ={ dp[i - 1][j - 1] if s1.charAt(i - 1) equals s2.charAt(j - 1), because the current character is equal, so the deletion should be same with s1.substring(i - 1) and s2.substring(j - 1);
         *            { min(dp[i - 1][j] + s1.chatAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1)), if the current character is not equal, so the minimum deletion should be the
         *            smaller one of (deletion of s1.substring(0, i - 1) and s2.substring(0, j) + s1.charAt(i - 1)) and (deletion of s1.substring(0, i) and s2.substring(0, j - 1) + s2.charAt(j - 1))
         *
         **/
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i + j > 0) {
                    if (i == 0) {
                        dp[0][j] = dp[0][j - 1] + chs2[j - 1];
                    } else if (j == 0) {
                        dp[i][0] = dp[i - 1][0] + chs1[i - 1];
                    } else {
                        if (chs1[i - 1] == chs2[j - 1]) {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = Math.min(dp[i - 1][j] + chs1[i - 1], dp[i][j - 1] + chs2[j - 1]);
                        }
                    }
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }

    public int minimumDeleteSum2(String s1, String s2) {
        /**
         * use dp[i][j] to represent minimum  ascii deletion to make s1.substring(0, i) and s2.substring(0, j);
         * so there comes the transition,
         *             { 0  if(i = 0 and j = 0) means to make ""(s1.substring(0,0)) and ""(s2.substring(0,0)) equal, there is no need to delete
         * transition ={ dp[i - 1][j - 1] if s1.charAt(i - 1) equals s2.charAt(j - 1), because the current character is equal, so the deletion should be same with s1.substring(i - 1) and s2.substring(j - 1);
         *            { min(dp[i - 1][j] + s1.chatAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1)), if the current character is not equal, so the minimum deletion should be the
         *            smaller one of (deletion of s1.substring(0, i - 1) and s2.substring(0, j) + s1.charAt(i - 1)) and (deletion of s1.substring(0, i) and s2.substring(0, j - 1) + s2.charAt(j - 1))
         *
         **/
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        for (int i = 1; i < dp.length; i++)
            dp[i][0] = dp[i - 1][0] + chs1[i - 1];

        for (int j = 1; j < dp[0].length; j++)
            dp[0][j] = dp[0][j - 1] + chs2[j - 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + chs1[i - 1], dp[i][j - 1] + chs2[j - 1]);
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }
}
