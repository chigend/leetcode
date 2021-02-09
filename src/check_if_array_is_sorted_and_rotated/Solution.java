package check_if_array_is_sorted_and_rotated;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        boolean check = check(ArrayTestCaseTransformer.transform("[3,4,5,1,2]"));
        System.out.println(check);
    }

    public static boolean check(int[] nums) {
        boolean rotated = nums[0] > nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (rotated) {
                    rotated = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
