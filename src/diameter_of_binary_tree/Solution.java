package diameter_of_binary_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-24-下午9:06
 */

public class Solution {
    private static int max;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        int max = diameterOfBinaryTree(node);
        System.out.print(max);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        depth(root);
        return max;
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        max = Math.max(leftDepth+rightDepth, max);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
