package minimum_distance_between_bst_nodes;

import model.TreeNode;

/**
 * recursive solution
 */
public class Solution {
    private Integer pre = null;
    private int min = Integer.MAX_VALUE;
    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        dfs(root.right);
    }
}
