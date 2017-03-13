package contains_duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yejinbiao
 * @create 2017-03-13-上午10:39
 */

public class Solution {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> table = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            /**
             * if it does not contain the num,it will return true
             */
            if (!table.add(num)) {
                return true;
            }
        }
        return false;
    }
}
