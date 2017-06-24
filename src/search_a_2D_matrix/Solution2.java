package search_a_2D_matrix;

/**
 * @author yejinbiao
 * @create 2017-06-24-20:58
 */

public class Solution2 {
    public static void main(String[] args) {

    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while (low <= high) {
            int med = (low + high) >> 1;
            int num = matrix[med / n][med % n];
            if (num < target){
                low = med + 1;
            }else if (num > target) {
                high = med - 1;
            }else return true;
        }
        return false;
    }
}
