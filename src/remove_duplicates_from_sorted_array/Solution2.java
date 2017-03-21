package remove_duplicates_from_sorted_array;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-21-下午3:14
 */

public class Solution2 {
    public static void main(String[] args) {
        int [] nums = {1,1,2};
        int len = removeDuplicates(nums);
        System.out.print(len);
        System.out.print(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 1;
        int fast = 1;
        int current = nums[0];
        while (fast < nums.length) {
            int num = nums[fast];
            if (num != current) {
                nums[slow++] = num;
                current = num;
            }
            fast++;
        }
        return slow;
    }
}
