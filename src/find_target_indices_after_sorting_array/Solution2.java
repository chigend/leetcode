package find_target_indices_after_sorting_array;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> targetIndices(int[] nums, int target) {
        int lt_target = 0;
        int eq_target = 0;

        for (int num : nums) {
            if (num < target) {
                lt_target++;
            }
            if (num == target) {
                eq_target++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = lt_target; i < lt_target + eq_target; i++) {
            res.add(i);
        }
        return res;
    }
}
