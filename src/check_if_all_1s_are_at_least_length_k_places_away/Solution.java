package check_if_all_1s_are_at_least_length_k_places_away;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] transform = ArrayTestCaseTransformer.transform("[1,0,0,0,1,0,0,1]");
        boolean b = kLengthApart(transform, 2);
        System.out.println(b);
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int previous = -(k+1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - previous - 1 < k) {
                    return false;
                }
                previous = i;
            }
        }
        return true;
    }
}
