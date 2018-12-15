package minimum_falling_path_sum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int min = solution.minFallingPathSum(new int[][]{{1,2,3}});
        System.out.println(min);
    }

    public int minFallingPathSum(int[][] A) {
        for (int i = A.length - 2; i >= 0 ; i--) {
            for (int j = 0; j < A[0].length; j++) {
                int min = A[i + 1][j];
                if (j > 0) {
                    min = Math.min(min, A[i + 1][j - 1]);
                }
                if (j < A[0].length - 1) {
                    min = Math.min(min, A[i + 1][j + 1]);
                }
                A[i][j] += min;
            }
        }
        int minimum = Integer.MAX_VALUE;
        for (int num : A[0]) {
            minimum = Math.min(minimum, num);
        }
        return minimum;
    }
}
