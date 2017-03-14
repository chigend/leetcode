package find_all_duplicates_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-14-下午9:15
 */

public class Solution {
    public static void main(String[] args) {
        int [] array = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(array);
        System.out.println(duplicates);
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                num = -num;
            }
            if (nums[num - 1] < 0) {
                result.add(num);
                continue;
            }
            nums[num - 1] = -nums[num - 1];
        }
        return result;
    }
}
