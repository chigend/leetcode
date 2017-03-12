package sum_of_left_leaves;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-12-下午2:19
 */

public class Solution {
    public static void main(String [] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node4.right = new TreeNode(7);
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;
        int leafLeaveSum = sumOfLeftLeaves(node);
        System.out.print(leafLeaveSum);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        return traversal(root, false);
    }
    private static int traversal(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }
        /**
         * if it is left node and it's a leaf node  return the node's value
         */
        if (isLeft && root.left == null && root.right == null) {
            return root.val;
        }
        /**
         * if it is not a leaf node then search deeper.
         */
        int lSum = traversal(root.left, true);
        int rSum = traversal(root.right, false);
        return lSum + rSum;
    }
}
