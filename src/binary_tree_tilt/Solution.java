package binary_tree_tilt;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-05-13-12:06
 */

public class Solution {
    private static int totalTilt = 0;

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
        int tilt = findTilt(node);
        System.out.println(tilt);
    }
    public  static int findTilt(TreeNode root) {
        traversal(root);
        return totalTilt;
    }
    private static int traversal(TreeNode root) {
        if (root == null) return 0;
        int lSum = traversal(root.left);
        int rSum = traversal(root.right);
        totalTilt += Math.abs(lSum-rSum);
        return lSum + rSum + root.val;
    }
}
