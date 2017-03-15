package product_of_array_except_self;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-15-下午1:43
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,0};
        int [] products = productExceptSelf(nums);
        System.out.print(Arrays.toString(products));
    }

    public static int[] productExceptSelf(int[] nums) {
        int countZero = 0;
        int zeroIndex = -1;
        int [] products = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                zeroIndex = i;
                countZero++;
                continue;
            }
            product *= nums[i];
        }
        if (countZero > 1) {
            return products;
        }
        if (countZero == 1) {
            products[zeroIndex] = product;
            return products;
        }
        for (int i = 0; i < nums.length; i++) {
            products[i] = product / nums[i];
        }
        return products;
    }
}
