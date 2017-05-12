package reshape_the_matrix;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-05-12-17:59
 */

public class Solution {
    public static void main(String[] args) {
        int [] []nums = {{1,2},{3,4}};
        nums = matrixReshape(nums,1,4);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int originalR = nums.length;

        int originalC = nums[0].length;
        if (originalR * originalC != r * c) return nums;
        int [] candidates = new int[originalR*originalC];
        int index = 0;
        for (int i = 0; i < originalR; i++){
            for (int j = 0; j < originalC; j++){
                candidates[index++] = nums[i][j];
            }
        }
        index = 0;
        int [][]result = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                result[i][j] = candidates[index++];
            }
        }
        return result;
    }
}
