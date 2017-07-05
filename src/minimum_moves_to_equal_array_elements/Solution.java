package minimum_moves_to_equal_array_elements;

/**
 * @author yejinbiao
 * @create 2017-07-05-9:53
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1};
        int steps = minMoves(nums);
        System.out.println(steps);
    }

    /**
     * assume the equal number to be x ,and move steps to be m
     * so nx = sum + (n - 1) * m; but x comes to be the min number
     * in the array plus steps, since it is the min number, so in order
     * to reach to the equal number,every move it should increment by 1
     * so x = min + m,we rearrange the formula. m = sum - n* min;
     * @param nums
     * @return
     */
    public static int minMoves(int[] nums) {
        int sum = 0;
        int min = 2147483647;
        for (int num : nums) {
            sum += num;
            min = Math.min(num,min);
        }
        return sum - nums.length * min;
    }
}
