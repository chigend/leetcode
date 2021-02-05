package how_many_numbers_are_smaller_than_the_current_number;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] ints = smallerNumbersThanCurrent(new int[]{6,5,4,8});
        System.out.println(Arrays.toString(ints));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] count = new int[101];
        for (int num : nums) {
            count[num] += 1;
        }

        int[] dp = new int[101];
        for (int i = 1; i <= 100; i++) {
            dp[i] = dp[i - 1] + count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = dp[nums[i]];
        }
        return nums;
    }
}
