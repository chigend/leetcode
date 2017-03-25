package find_mode_in_binary_search_tree;

import model.TreeNode;

import java.util.*;

/**
 * use a map to record the count of every val and the max count
 *
 * and last iterate the map ,keep the val that count is equal to the max count
 */

public class Solution {
    private static int maxCount = 0;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
//        node.right = node3;
//        node3.left = node4;
        int [] nums = findMode(node);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] findMode(TreeNode root) {
        Map<Integer,Integer> table = new HashMap<>();
        traversal(root, table);
        List<Integer> result = new ArrayList<>();
        for (Integer key : table.keySet()) {
            if (table.get(key) == maxCount) {
                result.add(key);
            }
        }
        int [] nums = new int[result.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result.get(i);
        }
        return nums;

    }

    private static void traversal(TreeNode root, Map<Integer, Integer> table) {
        if (root == null) return;
        traversal(root.left, table);
        int count = table.getOrDefault(root.val, 0) + 1;
        table.put(root.val, count);
        maxCount = Math.max(maxCount, count);
        traversal(root.right, table);
    }
}
