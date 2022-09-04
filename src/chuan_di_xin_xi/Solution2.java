package chuan_di_xin_xi;

public class Solution2 {

    public static void main(String[] args) {


    }

    /**
     * 动态规划写法
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp= new int[k+1][n];
        //dp[i][j]代表第i轮传递到第j个同学的方案数,从0开始,故第0轮传递到第0个同学的方案数为1
        dp[0][0] = 1;
        for(int i= 1; i <= k; i++) {
            for(int[] edge : relation) {
                dp[i][edge[1]] += dp[i - 1][edge[0]];
            }
        }
        return dp[k][n-1];
    }
}
