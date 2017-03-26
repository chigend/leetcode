package third_maximum_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author yejinbiao
 * @create 2017-03-26-14:37
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5, 3, 5};
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        List<Integer> largest = new ArrayList<>();
        out:
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int size = Math.min(largest.size(), 3);
            for (int j = 0; j < size; j++) {
                if (num == largest.get(j)) continue out;
                if (num > largest.get(j)) {
                    largest.add(j, num);
                    continue out;
                }
            }
            if (size < 3) largest.add(num);
        }
        return largest.size() < 3 ? largest.get(0) : largest.get(2);
    }
}
