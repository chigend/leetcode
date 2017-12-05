package image_smoother;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] M = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        M = imageSmoother(M);
        for (int i = 0; i < M.length; i++) {
            System.out.println(Arrays.toString(M[i]));
        }
    }

    public static int[][] imageSmoother(int[][] M) {
        int m = M.length;
        if (m == 0) {
            return new int[0][];
        }
        int n = M[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = average(M, i, j);
            }
        }
        return result;
    }

    private static int average(int[][] M, int i, int j) {
        int count = 0;
        int gray = 0;
        for (int k = Math.max(i - 1, 0); k <= Math.min(M.length - 1, i + 1); k++) {
            for (int l = Math.max(j - 1, 0); l <= Math.min(M[0].length - 1, j + 1);l++) {
                gray += M[k][l];
                count++;
            }
        }
        return gray / count;
    }
}
