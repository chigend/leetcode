package find_the_duplicate_number;

/**
 * @author yejinbiao
 * @create 2017-03-19-下午5:34
 */

public class Solution {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                num = -num;
            }
            if (nums[num - 1] < 0) {
                return num;
            }
            nums[num - 1] = - nums[num - 1];
        }
        return -1;
    }
}
