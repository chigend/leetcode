package shortest_unsorted_continuous_subarray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int shortest = findUnsortedSubarray(nums);
        System.out.println(shortest);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums,0,temp,0,nums.length);
        Arrays.sort(temp);
        int shortest = nums.length;
        int s = 0;
        while (shortest > 0 && temp[s] == nums[s]) {
            s++;
            shortest--;
        }

        s = nums.length - 1;
        while (shortest > 0 && temp[s] == nums[s]) {
            s--;
            shortest--;
        }
        return shortest;
    }
}
