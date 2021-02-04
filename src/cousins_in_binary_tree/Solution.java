package cousins_in_binary_tree;

import model.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.println(isCousins(node1, 4, 5));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (x == y) {
            return false;
        }

        int xDepth = calculateDepth(root, x);
        int yDepth = calculateDepth(root, y);
        return xDepth == yDepth && !isSibling(root, x, y);
    }

    public static int calculateDepth(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }

        if (root.val == value) {
            return 1;
        }

        int lDepth = calculateDepth(root.left, value);
        int rDepth = calculateDepth(root.right, value);

        int childDepth = Math.max(lDepth, rDepth);
        if (childDepth > 0) {
            return 1 + childDepth;
        }

        return 0;
    }

    public static boolean isSibling(TreeNode node, int x, int y) {
        if (node == null) {
            return false;
        }
        if (node.left != null && node.right != null && (node.left.val == x && node.right.val == y
                || node.left.val == y && node.right.val == x)) {
            return true;
        }

        return isSibling(node.left, x, y) || isSibling(node.right, x, y);

    }

}
