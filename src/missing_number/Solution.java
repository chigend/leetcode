package missing_number;

/**
 * @author yejinbiao
 * @create 2017-03-13-上午10:31
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {0,1,3};
        int missingNum = missingNumber(nums);
        System.out.println(missingNum);
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (1 + n) * n / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}
