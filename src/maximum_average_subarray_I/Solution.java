package maximum_average_subarray_I;

/**
 * @author yejinbiao
 * @create 2017-07-16-9:32
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
       System.out.println( findMaxAverage(nums,4));
    }
    public static double findMaxAverage(int[] nums, int k) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                sum += nums[i];
                if (i == k - 1) {
                    max = Math.max(max, sum);
                }
            } else {
                sum -= nums[i - k];
                sum += nums[i];
                max = Math.max(max, sum);
            }
        }
        return (double) max/k;
    }
}
