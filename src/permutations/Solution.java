package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午12:45
 */

public class Solution {
    private static int [] candidate ;
    private static boolean [] picked;
    public static void main(String[] args) {
        int [] nums = {1,2};
        List<List<Integer>> result = permute(nums);
        System.out.print(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        candidate = nums;
        picked = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>());
        return result;
    }


    private static void dfs(List<List<Integer>> result, List<Integer> container) {
        if (container.size() == candidate.length) {
            result.add(new ArrayList<>(container));
        }
        for (int i = 0; i < candidate.length; i++) {
            if (!picked[i]) {
                container.add(candidate[i]);
                picked[i] = true;
                dfs(result, container);
                container.remove(container.size() - 1);
                picked[i] = false;
            }
        }

    }
}
