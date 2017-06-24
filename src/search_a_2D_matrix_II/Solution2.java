package search_a_2D_matrix_II;

/**
 * @author yejinbiao
 * @create 2017-06-24-20:34
 */

public class Solution2 {
    public static void main(String[] args) {

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            int num = matrix[row][col];
            if (num < target) {
                row++;
            }else if (num > target) {
                col--;
            }else return true;
        }
        return false;
    }
}
