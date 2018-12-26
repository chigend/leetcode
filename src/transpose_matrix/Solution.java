package transpose_matrix;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] res = solution.transpose(new int[][]{{1,2,3},{4,5,6}});
        for (int i = 0; i <  res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }

    public int[][] transpose(int[][] A) {
        int[][] transpose = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }
}
