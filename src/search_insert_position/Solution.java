package search_insert_position;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午4:35
 */

public class Solution {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            }else if (nums[mid] < target) {
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return low;
    }
}
