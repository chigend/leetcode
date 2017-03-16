package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-16-上午10:42
 */

public class Solution {
    public static void main(String[] args) {
        int [][] matrix = {
                {1},
                {2},
                {3}
        };
        List<Integer>result = spiralOrder(matrix);
        System.out.print(result);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart;i <= colEnd; i ++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart;i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart > rowEnd || colStart > colEnd) {
                break;
            }
            for (int i = colEnd; i >= colStart; i--) {
                result.add(matrix[rowEnd][i]);
            }
            rowEnd--;
            for(int i = rowEnd; i >= rowStart; i--) {
                result.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return result;
    }
}
