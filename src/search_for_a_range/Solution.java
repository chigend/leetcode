package search_for_a_range;

/**
 * @author yejinbiao
 * @create 2017-03-22-上午10:20
 */

public class Solution {
    public static void main(String[] args) {

    }
    public  static int[] searchRange(int[] nums, int target) {
        int start = findFirst(nums,0, nums.length - 1,target);
        if (start == -1) {
            return new int[]{-1,-1};
        }
        int end = findLast(nums,start, nums.length - 1, target);
        return new int[]{start,end};
    }
    private static int findFirst(int[] nums, int low, int high, int target) {
        int index = -1;
        while (low <= high) {
            int med = (low + high) >> 1;
            if (nums[med] >= target) {
                high = med - 1;
            }else {
                low = med + 1;
            }
            if (nums[med] == target) {
                index = med;
            }
        }
        return index;
    }
    private static int findLast(int[] nums, int low, int high, int target) {
        int index = -1;
        while (low <= high) {
            int med = (low + high) >> 1;
            if (nums[med] <= target) {
                low = med + 1;
            }else {
                high = med - 1;
            }
            if (nums[med] == target) {
                index = med;
            }
        }
        return index;
    }
}
