package minimum_path_sum;

/**
 * 2016/11/22
 */
public class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[]{3, 1, 2};
        grid[1] = new int[]{1, 1, 1};
        grid[2] = new int[]{3, 2, 2};
        int min = minPathSum(grid);
        System.out.print(min);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = grid[i][j] + dp[i - 1][j];

                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }


}
