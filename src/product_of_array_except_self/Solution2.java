package product_of_array_except_self;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-15-下午2:27
 */

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {0,0};
        int[] products = productExceptSelf(nums);
        System.out.println(Arrays.toString(products));
    }

    /**
     * The idea is simply. The product basically is calculated using
     * the numbers before the current number and the numbers after
     * the current number. Thus, we can scan the array twice.
     * First, we calcuate the running product of the part before
     * the current number. Second, we calculate the running product
     * of the part after the current number through scanning from the
     * end of the array.
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] products = new int[len];
        if (len == 0) {
            return products;
        }
        products[0] = 1;
        for (int i = 1; i < len; i++) {
            products[i] = nums[i - 1] * products[i - 1];
        }
        int rightProduct = 1;
        for (int i = len - 1; i >= 0; i--) {
            products[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return products;
    }
}
