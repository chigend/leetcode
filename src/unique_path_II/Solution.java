package unique_path_II;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

/**
 * @author yejinbiao
 * @create 2017-03-29-18:52
 */

public class Solution {
    public static void main(String[] args) {
        int [][] obstacleGrid = {
                {0,1,0},
                {0,1,0},
                {0,1,0}

        };
        int paths = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(paths);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        //if the first block is obstacle,there is no path
        if (obstacleGrid[0][0] == 1)return 0;
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if the current block is obstacle, to unique paths to this block will 0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                //if the current row is not the first row ,we should add unique paths to block[i-1][j]
                if (i - 1 >= 0 ) dp[i][j] += dp[i - 1][j];
                //if the current col is not the first col, we should add unique paths to block[i][j-1]
                if (j - 1 >= 0 ) dp[i][j] += dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];

    }

}
