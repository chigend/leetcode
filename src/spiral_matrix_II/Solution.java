package spiral_matrix_II;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-16-下午12:22
 */

public class Solution {
    public static void main(String[] args) {
        int [][]matrix = generateMatrix(0);
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(Arrays.toString(matrix[i]));
        }
    }


    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int end = n * n;
        int count = 1;
        while (count <= end) {
            for (int i = colStart;i <= colEnd; i ++) {
                matrix[rowStart][i] = count++;
            }
            rowStart++;
            for (int i = rowStart;i <= rowEnd; i++) {
                matrix[i][colEnd] = count++;
            }
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) {
                break;
            }
            for (int i = colEnd; i >= colStart; i--) {
                matrix[rowEnd][i] = count++;
            }
            rowEnd--;
            for(int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = count++;
            }
            colStart++;
        }
        return matrix;
    }
}
