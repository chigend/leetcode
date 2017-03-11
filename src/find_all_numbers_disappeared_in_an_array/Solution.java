package find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-11-下午8:11
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * because the 1<= nums[i] <= nums.length,
         * so when meet the num at nums[i],just use the num as the index of array,
         * and flip nums[num - 1] to negative.when num is < 0,it means it has been
         * filpped, so use -num - 1 as the index of array, flip nums[-num-1] to negative
         * finally,traversal the original nums array, if there exist i that nums[i] > 0,
         * it means that  (i + 1) is the number that disappeared in array(because if it exist,
         * it will the num[i] to negative)
         */
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0;i < nums.length; i ++) {
            int num = nums[i];
            if (num < 0) {
                num = - num;
            }
            if (nums[num - 1] > 0) {
                nums[num - 1] = - nums[num - 1];
            }
        }
        for (int i = 0;i < nums.length; i ++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
