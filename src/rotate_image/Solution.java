package rotate_image;

/**
 * @author yejinbiao
 * @create 2017-03-18-下午1:31
 */

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3,4},
                {4, 5, 6,10},
                {7, 8, 9,11},
                {12,13,14,15}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int round = n / 2;
        for (int i = 0; i < round; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }

    }
}
