package maximum_width_of_binary_tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class Solution3 {
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
        node2.right = node5;
        //        node3.right = node7;
        //        node3.right = node5;
        //        node4.left = node6;
        //        node5.right = node7;
        int width = widthOfBinaryTree(node);
        System.out.println(width);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0, new ArrayList<>());
        return max;
    }

    private static void dfs(TreeNode root, int level, int index, List<Integer> width) {
        if (root == null) {
            return;
        }
        if (level == width.size()) {
            width.add(index);
        }
        max = Math.max(max, index - width.get(level) + 1);
        dfs(root.left, level + 1, 2 * index + 1, width);
        dfs(root.right, level + 1, 2 * index + 2, width);
    }
}
