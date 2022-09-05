package search_insert_position;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午4:35
 */

public class Solution {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = r + (l - r >> 1);
            if (nums[mid] >= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return nums[r] >= target ? r : r + 1;
    }
}
