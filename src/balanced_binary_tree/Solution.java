package balanced_binary_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-25-下午12:44
 */

public class Solution{
    private boolean isBalanced = true;
    public static void main(String[] args) {

    }


    public boolean isBalanced(TreeNode root) {
        depth(root);
        return isBalanced;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if (Math.abs(lDepth - rDepth) > 1) isBalanced = false;
        return 1 + Math.max(lDepth, rDepth);
    }
}
