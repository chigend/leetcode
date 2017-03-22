package validate_binary_search_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-22-上午8:52
 */

public class Solution {
    private static Integer previous;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(20);
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;
        boolean isValid = isValidBST(node);
        System.out.print(isValid);
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (previous != null && root.val <= previous) {
            return false;
        }
        previous = root.val;
        return isValidBST(root.right);
    }




    }
}
