package combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		List<List<Integer>> result = combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		combinationSum(candidates, target, result, temp, 0);
		return result;
	}

	public static void combinationSum(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp,
			int start) {
		int sum = calculateSum(temp);
		if (sum == target) {
			result.add(new ArrayList<Integer>(temp));
		} else if (sum < target) {

			for (int i = start; i < candidates.length; i++) {
				temp.add(candidates[i]);
				combinationSum(candidates, target, result, temp, i);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private static int calculateSum(List<Integer> temp) {
		int sum = 0;
		for (int i : temp) {
			sum += i;
		}
		return sum;
	}
}
