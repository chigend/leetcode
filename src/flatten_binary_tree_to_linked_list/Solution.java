package flatten_binary_tree_to_linked_list;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-08-25-9:37
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        TreeNode node8 = new TreeNode(10);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        node5.right = node8;
        flatten(node);
        System.out.println(node);
    }

    public static void flatten(TreeNode root) {
        flatten0(root);
    }

    private static TreeNode flatten0(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = flatten0(root.left);
        TreeNode right = flatten0(root.right);
        if (left == null) {
            return root;
        }
        TreeNode last = findBottom(left);

        last.right = root.right;
        root.right = left;
        root.left = null;
        return root;
    }

    private static TreeNode findBottom(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
