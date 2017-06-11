package next_permutation;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午2:49
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        for (int i = nums.length -1; i > 0; i--) {
            /**
             * if the number is larger than it's previous number,it means the previous number
             * should be replaced with a larger number,since we are to find the number that is
             * larger than the previous,so the numbers after(inclusive) current position should be descending
             * order, so when we find the num which is larger than previous number,just reverse the descending
             * part(after we have already replace the previous number with a least larger number)
             */
            if (nums[i] > nums[i - 1]) {
                int leastLarger = nums.length - 1;
                /**
                 * just scan from the end of the array to find the first the number that is
                 * larger than the previous number,replace it with the first larger number
                 * (it's the least larger number)
                 */
                while (nums[leastLarger] <= nums[i - 1]) leastLarger--;
                swap(nums,leastLarger,i-1);
                /**
                 * record the position after which the array should be reverse
                 */
                low = i;
                break;
            }
        }
/**
 * if the total array is in descending order, it means it is the largest one, so next one should
 * be reset to a lowest order. so we reverse the whole array since low is init with 0
 */
        while (low < high) {
            swap(nums,low,high);
            low++;
            high--;
        }
    }
    private static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
