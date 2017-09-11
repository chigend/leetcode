package _3_sum_closest;

import java.util.Arrays;

public class Solution {
    public static int[] candidates;
    public static void main(String[] args) {
        int[] num = {-1,2,1,-4};
        int closet = threeSumClosest(num, 1);
        System.out.println(closet);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int closest = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return sum;
                }else {
                    int diff = sum - target;
                    if (Math.abs(diff) < min) {
                        min = Math.abs(diff);
                        closest = sum;
                    }
                    if (diff < 0) {
                        start++;
                    }else {
                        end--;
                    }

                }
            }
        }
        return closest;
    }


}
