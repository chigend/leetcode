package binary_prefix_divisible_by_5;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Boolean> booleans = prefixesDivBy5(new int[]{1, 0, 1, 1, 1, 0});
        System.out.println(booleans);
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        int result = 0;
        List<Boolean> res = new ArrayList<>(nums.length);

        for (int num : nums) {
            result = result << 1 | num;
            if (result >= 10) {
                result -= 10;
            }
            res.add((result % 5) == 0);
        }
        return res;
    }
}
