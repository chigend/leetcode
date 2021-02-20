package binary_search_tree_to_greater_sum_tree;

import java.util.Stack;

import model.TreeNode;
import tool.TreeNodeTestCaseTransformer;

public class Solution2 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeTestCaseTransformer.transformTreeNode("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        TreeNode treeNode = bstToGst(root);
        System.out.println(treeNode);
    }

    public static TreeNode bstToGst(TreeNode root) {
        TreeNode res = root;
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            root.val = sum += root.val;
            root = root.left;
        }
        return res;
    }
}
