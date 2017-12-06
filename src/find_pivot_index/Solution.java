package find_pivot_index;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        int index = pivotIndex(nums);
        System.out.println(index);
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] - nums[i] == sum[sum.length - 1] - sum[i]) {
                return i;
            }
        }
        return -1;
    }
}
