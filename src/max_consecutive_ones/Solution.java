package max_consecutive_ones;

/**
 * @author yejinbiao
 * @create 2017-03-11-下午7:33
 */

public class Solution {
    public static void main(String [] args) {
        int [] binary = {1,1,0,1,1,1};
        int max = findMaxConsecutiveOnes(binary);
        System.out.println(max);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLength = 0;
        boolean consecutive = true;
        int count = 0;
        for (int i = 0;i < nums.length; i ++) {
            if (nums[i] == 0) {
                consecutive = false;
                continue;
            }else {
                if (!consecutive) {
                    maxLength = Math.max(maxLength, count);
                    count = 0;
                }
                count++;
                consecutive = true;
            }
        }
        return Math.max(maxLength, count);
    }
}
