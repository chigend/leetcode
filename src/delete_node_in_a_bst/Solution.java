package delete_node_in_a_bst;

import model.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        TreeNode result = deleteNode(node, 5);
        System.out.println(result);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            }
            TreeNode min = root.right;

            while (min.left != null) {
                min = min.left;
            }
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        return root;
    }

}
