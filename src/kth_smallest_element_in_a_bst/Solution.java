package kth_smallest_element_in_a_bst;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午9:20
 */

public class Solution {
    private static int count ;
    private static int kthsmallest;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3= new TreeNode(3);
        node.left = node2;
        node.right = node3;
        int kthSmallest = kthSmallest(node, 1);
        System.out.print(kthSmallest);
    }

    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTraversal(root);
        return kthsmallest;
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }
        inorderTraversal(root.left);
        count--;
        if (count == 0) {
            kthsmallest = root.val;
        }
        inorderTraversal(root.right);
    }
}
