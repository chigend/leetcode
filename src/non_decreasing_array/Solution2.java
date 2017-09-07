package non_decreasing_array;

/**
 * there is no need to use stack .....because the original array can be treated as a stack to look up the historical number
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (++count > 1) {
                    return false;
                }
                if (i > 1 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                }else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return count <= 1;
    }
}
