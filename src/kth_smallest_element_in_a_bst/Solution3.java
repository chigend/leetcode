package kth_smallest_element_in_a_bst;

import model.TreeNode;

/**
 *  binary search solution
 */

public class Solution3 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        node.right = node1;
        int val = kthSmallest(node, 2);
        System.out.print(val);
    }

    public static int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        /**
         * if k is less than nodes count of left subtree of root,it means the number is in left subtree.
         */
        if (k <= count) {
            kthSmallest(root.left,k);
        }
        /**
         * k - 1 means count the current node , if it is larger than count,it means it number is in right subtree.
         */
        else if (k - 1 > count){
            kthSmallest(root.right, k - 1 - count);
        }
        /**
         * if k - 1 - count = 0, it means the current node is the kth number
         */
        return root.val;
    }
    private static int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}
