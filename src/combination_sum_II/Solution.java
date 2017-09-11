package combination_sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int[] candidate;
    public static List<List<Integer>> result;
    public static void main(String[] args) {
        int[] candidates = {1,1,3,4,5};//{1,1,2,5,6,7,10}
        List res = combinationSum2(candidates, 2);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        candidate = candidates;
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrace(0, 0, target, list);
        return result;
    }

    /**
     *
     * @param start
     * @param sum
     * @param target
     * @param list
     * @return return true if the backtrace should be cut and terminate
     * return false if it should continue to backtrace
     */
    private static boolean backTrace(int start, int sum, int target, List<Integer> list) {
        if (sum > target) {
            return true;
        }
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return true;
        }
        for (int i = start; i < candidate.length; i++) {
            if (i > start && candidate[i] == candidate[i - 1]) {
                continue;
            }
            list.add(candidate[i]);
            boolean cut = backTrace(i + 1, sum + candidate[i], target, list);
            list.remove(list.size() - 1);
            if (cut) {
                return false;
            }

        }
        return false;
    }
}
