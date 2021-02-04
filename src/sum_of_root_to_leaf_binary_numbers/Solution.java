package sum_of_root_to_leaf_binary_numbers;

import model.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(1);

        node1.left = node2;
        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
        System.out.println(sumRootToLeaf(node1));
    }

    public static int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf0(root, 0);
    }

    public static int sumRootToLeaf0(TreeNode root, int parent) {
        if (root == null) {
            return 0;
        }
        int v = parent << 1 | root.val;

        if (root.left == null && root.right == null) {
            return v;
        }
        return sumRootToLeaf0(root.left, v) + sumRootToLeaf0(root.right, v);
    }
}
