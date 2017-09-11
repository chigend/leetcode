package combination_sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static int[] candidate;
    public static List<List<Integer>> result;
    public static void main(String[] args) {
        int[] candidates = {1, 1, 3, 4, 5};//{1,1,2,5,6,7,10}
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

    private static void backTrace(int start, int sum, int target, List<Integer> list) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        for (int i = start; i < candidate.length; i++) {
            //since the candidate array is sorted, there is no need to check the element later because
            //the current num is invalid
            if (sum + candidate[i] > target) {
                break;
            }
            //filter the duplicate combine
            if (i > start && candidate[i] == candidate[i - 1]) {
                continue;
            }
            list.add(candidate[i]);
            backTrace(i + 1, sum + candidate[i], target, list);
            list.remove(list.size() - 1);
        }
    }
}
