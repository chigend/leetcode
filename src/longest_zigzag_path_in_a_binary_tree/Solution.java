package longest_zigzag_path_in_a_binary_tree;

import model.TreeNode;
import tool.TreeNodeTestCaseTransformer;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNodeTestCaseTransformer.transformTreeNode("[1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]");
        solution.longestZigZag(root);
    }
    public int longestZigZag(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(dfs(root.left, true, 0), dfs(root.right, false, 0));
    }

    public int dfs(TreeNode root, boolean left, int path) {
        if(root == null) {
            return path;
        }

        if(left) {
            int d = dfs(root.right, false, path + 1);
            return Math.max(dfs(root.left, true, 0), d);

        }else{
            int d = dfs(root.left, true, path + 1);
            return Math.max(dfs(root.right, false, 0), d);
        }

    }
}