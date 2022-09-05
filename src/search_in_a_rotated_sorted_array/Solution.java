package search_in_a_rotated_sorted_array;

import tool.ArrayTestCaseTransformer;

/**
 * @author yejinbiao
 * @create 2017-06-25-20:15
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = ArrayTestCaseTransformer.transform("[4,5,6,7,0,1,2]");
        Solution solution = new Solution();

        int index = solution.search(nums, 0);
        System.out.println(index);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int pivot = findPivot(nums);
        //then binary search left part and right part respectively
        int left = binarySearch(nums, 0, pivot, target);
        return left == -1 ? binarySearch(nums, pivot + 1, nums.length - 1, target) : left;
    }

    //first we find the index where it departs
    //for example [5,6,7,1,2,3,4]  we find the index of 7,in this case,we find 2
    private int findPivot(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int target = nums[r];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (nums[mid] > target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[r] == target ? r : -1;
    }
}
