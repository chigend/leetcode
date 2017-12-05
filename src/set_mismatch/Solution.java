package set_mismatch;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] result = findErrorNums(new int[]{1,2,2,4});
        System.out.println(Arrays.toString(result));
    }

    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                num = -num;
            }
            if (nums[num - 1] < 0){
                result[0] = num;
                continue;
            }
            nums[num - 1] = -nums[num - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
                return result;
            }
        }
        return result;
    }
}
