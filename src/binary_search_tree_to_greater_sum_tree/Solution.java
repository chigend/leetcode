package binary_search_tree_to_greater_sum_tree;

import model.Node;
import model.TreeNode;
import tool.TreeNodeTestCaseTransformer;

public class Solution {

    public static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNodeTestCaseTransformer.transformTreeNode("[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]");
        TreeNode treeNode = bstToGst(root);
        System.out.println(treeNode);
    }

    public static TreeNode bstToGst(TreeNode root) {
        bstToGst0(root);
        return root;
    }

    public static void bstToGst0(TreeNode root) {
        if (root == null) {
            return;
        }
        bstToGst0(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst0(root.left);
    }
}
