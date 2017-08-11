package two_sum_IV;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-08-11-9:53
 */

public class Solution2 {
    private static TreeNode head;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        node.left = node2;
        node.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.right = node6;
        boolean exist = findTarget(node, 4);
        System.out.println(exist);
    }

    public static boolean findTarget(TreeNode root, int k) {
        head = root;
        return  traversal(root, k);
    }

    private static boolean traversal(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        int target = k - root.val;
        return (target != root.val && search(head, target)) || traversal(root.left, k)
                || traversal(root.right, k);

    }

    private static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (target > root.val) {
            return search(root.right, target);
        }
        if (target < root.val) {
            return search(root.left, target);
        }
        return true;
    }
}
