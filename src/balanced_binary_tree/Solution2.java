package balanced_binary_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-25-下午12:55
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    /**
     * avoid further useless search, once find a node that is not balanced  we return -1
     *
     */
    private int depth(TreeNode root) {
        if (root == null) return 0;
        int lDepth = depth(root.left);
        if (lDepth == -1) return -1;
        int rDepth = depth(root.right);
        if (rDepth == -1) return -1;
        if (Math.abs(lDepth - rDepth) > 1) return -1;
        return 1 + Math.max(lDepth, rDepth);
    }
}
