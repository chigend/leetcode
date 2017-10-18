package maximum_width_of_binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.TreeNode;

/**
 * dfs solution
 */
public class Solution {
    private static int max = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(9);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.left = node6;
        node5.right = node7;
        int width = widthOfBinaryTree(node);
        System.out.println(width);

    }

    public static int widthOfBinaryTree(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(map, root, 1, 0);
        return max;
    }

    private static void dfs(Map<Integer, List<Integer>> map, TreeNode root, int level, int index) {
        if (root == null) {
            return;
        }
        List<Integer> indexes = map.getOrDefault(level, new ArrayList<>());
        indexes.add(index);
        max = Math.max(indexes.get(indexes.size() - 1) - indexes.get(0) + 1, max);
        map.put(level, indexes);
        dfs(map, root.left, level + 1, 2 * index + 1);
        dfs(map, root.right, level + 1, 2 * index + 2);
    }
}
