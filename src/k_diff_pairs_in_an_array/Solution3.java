package k_diff_pairs_in_an_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-26-21:02
 */

public class Solution3 {
    public static void main(String[] args) {

    }

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer,Integer> table = new HashMap<>();
        int count = 0;
        for (int i : nums) table.put(i, table.getOrDefault(i, 0) + 1);
        for (Map.Entry<Integer,Integer> entry : table.entrySet()) {
            if (k == 0){
                if (entry.getKey() >= 2) count++;
            }else {
                if (table.containsKey(entry.getKey() + k)) count++;
            }
        }
        return count;
    }
}
