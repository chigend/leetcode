package array_partition_I;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-05-11-11:16
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,4,2,3};
        int sum = arrayPairSum(nums);
        System.out.println(sum);
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

}
