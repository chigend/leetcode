package toeplitz_matrix;

public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {{1,2},{2,2}};
        boolean is = isToeplitzMatrix(matrix);
        System.out.println(is);
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (j < n) {
            int k = i;
            int l = j;
            int num = matrix[k][l];
            while (++k < m && ++l < n) {
                if (matrix[k][l] != num) {
                    return false;
                }
            }
            if (i > 0) {
                i--;
            }else {
                j++;
            }
        }
        return true;
    }
}
