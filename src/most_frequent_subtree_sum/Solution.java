package most_frequent_subtree_sum;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-11-下午2:04
 */

public class Solution {
    private static int maxFrequent = 0;
    private static Map<Integer,Integer> table = new HashMap<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(-3);
        root.left = left;
        root.right = right;
        int [] sums = findFrequentTreeSum(root);
        Arrays.stream(sums).forEach(System.out::println);
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        calculateSum(root);
        ArrayList<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : table.entrySet()) {
            if (entry.getValue() == maxFrequent) {
                result.add(entry.getKey());
            }
        }
        int [] sums = new int[result.size()];
        for (int i = 0; i < result.size(); i ++) {
            sums[i] = result.get(i);
        }
        return sums;
    }
    private static int calculateSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubtreeSum = calculateSum(root.left);
        int rightSubtreeSum = calculateSum(root.right);

        int sum = leftSubtreeSum + rightSubtreeSum + root.val;

        int frequent = table.getOrDefault(sum,0) + 1;
        table.put(sum, frequent);
        maxFrequent = Math.max(frequent,maxFrequent);
        return sum;
    }
}
