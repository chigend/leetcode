package shortest_unsorted_continuous_subarray;

public class Solution2 {
    public static void main(String[] args) {

    }


    public static int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int end = -2;//init with 2,in case the array is already sorted
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[nums.length - 1 - i], min);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[nums.length - 1 - i] > min) {
                start = nums.length - 1 - i;
            }
        }
        return end - start + 1;
    }
}
