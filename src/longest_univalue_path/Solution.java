package longest_univalue_path;

import java.util.Map;

import model.TreeNode;

public class Solution {
    private static int max = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        int result = longestUnivaluePath(node);
        System.out.println(result);
    }

    public static int longestUnivaluePath(TreeNode root) {
        longestUnivaluePath0(root);
        return max;
    }

    private static int longestUnivaluePath0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestUnivaluePath0(root.left);
        int right = longestUnivaluePath0(root.right);
        int edgesLeft = 0;
        int edgesRight = 0;
        if (root.left != null && root.left.val == root.val) {
            edgesLeft = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            edgesRight = right + 1;
        }
        max = Math.max(max, edgesLeft + edgesRight);
        return Math.max(edgesLeft, edgesRight);
    }
}
