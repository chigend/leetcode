package single_number;

/**
 * @author yejinbiao
 * @create 2017-03-17-下午4:28
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,23,12,3,12,23,4,1};
        int num = singleNumber(nums);
        System.out.print(num);
    }

    public static int singleNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
