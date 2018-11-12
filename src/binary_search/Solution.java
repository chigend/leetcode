package binary_search;

public class Solution {
    public static void main(String [] args) {
        int[] nums = new int[]{1,2,3,4,6,6,7};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 5));
    }
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int med = (low + high) >> 1;
            if (nums[med] == target) {
                return med;
            }else if (nums[med] > target) {
                high = med - 1;
            }else {
                low = med + 1;
            }
        }
        return -1;
    }
}
