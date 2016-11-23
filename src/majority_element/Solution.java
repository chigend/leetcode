package majority_element;

import java.util.Arrays;

/**
 * 2016/11/23
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static int majorityElement(int[]nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
