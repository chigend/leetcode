package find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

import model.TreeNode;

public class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(original, cloned, target);
    }

    private TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }
        TreeNode left = dfs(original.left, cloned.left, target);
        return left == null ? dfs(original.right, cloned.right, target) : left;
    }
}
