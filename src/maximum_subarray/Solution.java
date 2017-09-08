package maximum_subarray;

public class Solution {
    public static void main(String[] args) {
//        -1 0 2 3
        int res = maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(res);
    }

    public static int maxSubArray(int[] nums) {
        int maxRes = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int min = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxRes = Math.max(maxRes, max - min);
            }
            if (nums[i] < min) {
                maxRes = Math.max(maxRes, max - min);
                min = nums[i];
                max = min*2;//in case the single number is the subarray   if we set the max to min  max-min will be 0
            }

        }
        return maxRes;
    }
}
