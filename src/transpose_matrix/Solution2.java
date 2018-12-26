package transpose_matrix;

import java.util.Arrays;

/**
 * and what if the input is a square matrix, can we do it in place
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] res = solution2.transpose(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        for (int i = 0; i <  res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[][] transpose(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A[i].length; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        return A;
    }
}
