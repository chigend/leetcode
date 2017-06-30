package maximum_product_of_three_numbers;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-06-25-9:34
 */

public class Solution {
    public static void main(String[] args) {

    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int num1 = nums[len - 1] * nums[len-2] * nums[len-3];
        int num2 = nums[len - 1] * nums[0] * nums[1];
        return num1 >= num2 ? num1 : num2;
    }
}
