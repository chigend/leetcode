package array_nesting;

import java.util.HashSet;
import java.util.Set;

import sun.plugin2.main.client.MessagePassingOneWayJSObject;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int lonest = solution.arrayNesting(new int[]{5,4,0,3,1,6,2});
        int lonest = solution.arrayNesting(new int[]{5,4,0,3,1,6,2});
        System.out.println(lonest);
    }

    public int arrayNesting(int[] nums) {
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                int index = i;
                int circleSize = 0;
                while (nums[index] >= 0) {
                    circleSize++;
                    int temp = nums[index];
                    nums[index] = -1;
                    index = temp;
                }
                longest = Math.max(longest, circleSize);
            }
        }
        return longest;
    }
}
