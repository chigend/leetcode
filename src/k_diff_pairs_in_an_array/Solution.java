package k_diff_pairs_in_an_array;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-26-20:11
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int count = findPairs(nums, 1);
        System.out.println(count);
    }

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        out:
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue ;
            for (int j = i + 1; j < nums.length; j ++) {

                if (nums[j] - nums[i] == k) {
                    count++;
                    continue out;
                }
            }
        }
        return count;
    }
}
