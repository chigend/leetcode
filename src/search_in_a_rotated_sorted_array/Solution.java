package search_in_a_rotated_sorted_array;

/**
 * @author yejinbiao
 * @create 2017-06-25-20:15
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {10,1};
        int index = search(nums,10);
        System.out.println(index);
    }
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int pivot = findPivot(nums);
        //then binary search left part and right part respectively
        int left = binarySearch(nums,0,pivot,target);
        return left == -1 ? binarySearch(nums,pivot+1,nums.length-1,target) : left;
    }

    //first we find the index where it departs
    //for example [5,6,7,1,2,3,4]  we find the index of 7,in this case,we find 2
    private static int findPivot(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int target = nums[high];
        while (low < high) {
            int med = (low + high) >> 1;
            if (nums[med] <= target) {
                high = med - 1;
            }else if (nums[med] > target) {
                low = med + 1;
            }
        }
        if (low == 0) return 0;
        return nums[low-1] > nums[low] ? low - 1 : low;

    }

    private static int binarySearch(int[] nums, int low, int high,int target) {
        while (low <= high) {
            int med = low + ((high - low) >> 1);
            if (nums[med] > target) {
                high = med - 1;
            }else if (nums[med] < target) {
                low = med + 1;
            }else return med;
        }
        return -1;
    }
}
