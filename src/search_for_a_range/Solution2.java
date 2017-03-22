package search_for_a_range;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-22-上午9:43
 */

public class Solution2 {
    public static void main(String[] args) {
        int [] nums = {0,7,7,7,7,7,8};
        nums = searchRange(nums,7);
        System.out.print(Arrays.toString(nums));
    }
    public  static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1,-1};
        }
        int left = index;
        int right = index;
        int low = left;
        int high = right;
        while (left != -1 || right != -1) {
            if (left != -1) {
                left = binarySearch(nums,0, left - 1, target);
                if (left != -1) {
                    low = left;
                }
            }
            if (right != -1) {
                right = binarySearch(nums,right + 1, nums.length - 1,target);
                if (right != -1) {
                    high = right;
                }
            }
        }
        return new int[]{low,high};
    }
    private static int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int med = (low + high) >> 1;
            if (nums[med] > target) {
                high = med - 1;
            }else if (nums[med] < target) {
                low = med + 1;
            }else {
               return med;
            }
        }
        return -1;
    }
}
