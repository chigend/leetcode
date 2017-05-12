package reshape_the_matrix;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-05-12-18:09
 */

public class Solution2 {
    public static void main(String[] args) {
        int [] []nums = {{1,2},{3,4}};
        nums = matrixReshape(nums,1,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
    public  static int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;

        int n = nums[0].length;
        if (n * m != r * c) return nums;

        int [][]result = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                result[row][col] = nums[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }
}
