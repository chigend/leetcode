package diagonal_traverse;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午12:45
 */

public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {{1}};
        int []result = findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return new int[0];
        }
        int n = matrix[0].length;
        int len = m * n;
        int [] result = new int[len];
        int row = 0;
        int col = 0;
        int index = 0;
        result[index++] = matrix[0][0];
        /**
         * split the traversal by two part,up to down (从上至下)part and down to up（从下至上） part
         */
        while (true) {
            /**
             * if col < n - 1, it means the row has reached the top border,
             * so just increase the col for new start of (up to down)traversal
             * if row >= 0, it means the col has reached the right border,
             * so  increase the row and set the col to last column for new start of (up to down)traversal.
             */
            if (col < n - 1) {
                col++;
            }else if(row >= 0) {
                row++;
                col = n - 1;
            }
            /**
             * traverse until row reached bottom border or column reached left border
             */
            while (row < m && col >= 0) {
                result[index++] = matrix[row++][col--];
            }
            /**
             * since one of row and column has been out of index,just roll back one step
             */
            row--;
            col++;
            /**
             * if both of row and col has reach the border,return
             */
            if (row >= m - 1 && col >= n - 1) {
                return result;
            }
            /**
             * if row < m - 1, it means column has reached left border(左边界)
             * it column >=0 , it means row has reached bottom border
             * set row and col to new start for down to up traversal
             */
            if (row < m - 1) {
                row++;
            }else if (col >= 0) {
                col++;
                row = m - 1;
            }
            /**
             * tranversal until row has reached top border or col has reached right border
             */
            while (row >= 0 && col < n) {
                result[index++] = matrix[row--][col++];
            }
            /**
             * since one of row and column has been out index ,just roll back one step
             */
            col--;
            row++;
            /**
             * if both of row and col has reached the border ,return result
             */
            if (row >= m - 1 && col >= n - 1) {
                return result;
            }
        }
    }
}
