package move_zeroes;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-09-下午5:27
 */

public class Solution {
    public static void main(String[] args) {
        int[] arr = {};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        int slow = 0; //a pointer to track the index at which the new value will move in
        int fast = 0; // a pointer to track the not-zero value index at which value will be moved out
        int countZero = 0; //a count which count the zeroes
        while (slow < nums.length) {
            while (fast < nums.length && nums[fast] == 0) {
                countZero++;
                fast++;
            }
            /**
             * if slow reached nums.length - countZero,it means the left should be filled with 0
             */
            if (slow >= nums.length - countZero) {
                nums[slow++] = 0;
            } else {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
    }
}
