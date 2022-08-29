package deepest_leaves_sum;

import model.TreeNode;
import tool.TreeNodeTestCaseTransformer;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.deepestLeavesSum(new TreeNode(1));
        System.out.println(i);
        //        TreeNodeTestCaseTransformer.transformTreeNode("[1,2,3,4,5,null,6,7,null,null,null,null,8]")
    }

    public int maxDepth = 0;
    public int res = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
        if (depth > maxDepth) {
            maxDepth = depth;
            res = root.val;
        } else if (depth == maxDepth) {
            res += root.val;
        }
    }

}
