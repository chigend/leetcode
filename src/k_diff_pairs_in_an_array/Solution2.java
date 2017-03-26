package k_diff_pairs_in_an_array;

import java.util.Arrays;

/**
 *  binary search solution
 */

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        int count = findPairs(nums,0);
        System.out.println(count);
    }
    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);//first sort the array
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            /**
             * since the array is sorted, it's ascending, and skip the number that has been calculate
             */
            if (i != 0 && nums[i] == nums[i - 1])continue;
            /**
             * since we are to find nums[i] - nums[j] == k, so just binary search the array from i + 1 for
             * target nums[i] + k,to reason why there is no need to search from 0 to nums.length - 1 is
             * that it must be searched before,if there exist j, that nums[j] =  nums[i] - k, so it must
             * be calculate when i == j above,num[i] = nums[j] + k just when
             */
            count += bianrySearch(nums, i + 1,nums[i] + k) ? 1 : 0;
        }
        return count;
    }
    private static boolean bianrySearch(int[]nums, int low, int target) {
        int high = nums.length - 1;
        while (low <= high) {
            int med = (low + high) >> 1;
            if (nums[med] > target) high = med - 1;
            else if (nums[med] < target) low = med + 1;
            else return true;
        }
        return false;
    }
}
