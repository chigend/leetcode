package convert_bst_to_greater_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-26-9:25
 */

public class Solution {
    private  Integer previous;
    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        if (previous != null) root.val += previous;
        previous = root.val;
        traversal(root.left);
    }
}
