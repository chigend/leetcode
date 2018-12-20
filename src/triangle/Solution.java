package triangle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  extra O(n^2) space solution
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> row1 = Arrays.asList(2);
        List<Integer> row2 = Arrays.asList(3,4);
        List<Integer> row3 =  Arrays.asList(6,5,7);
        List<Integer> row4 =  Arrays.asList(4,1,8,3);
        List<List<Integer>> list = Arrays.asList(row1,row2, row3, row4);
        int minimum = solution.minimumTotal(list);
        System.out.println(minimum);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            int len = triangle.get(i).size();
            dp[i] = new int[len];
            for (int j = 0; j < len; j++) {
                dp[i][j] = triangle.get(i).get(j);
                if (i < triangle.size() - 1) {
                    dp[i][j] += Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
