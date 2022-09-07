package binary_search;

public class Solution {
    public static void main(String [] args) {
        int[] nums = new int[]{1,2,3,4,6,6,7};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 5));
    }
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + r >> 1;
            if(nums[mid] >= target) {
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[r] == target ? r : -1;
    }
}
