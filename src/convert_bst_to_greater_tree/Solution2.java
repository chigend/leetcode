package convert_bst_to_greater_tree;

import model.TreeNode;

import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-26-11:07
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode result = root;
        int previous = 0;
        while (!stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                node.val += previous;
                previous = node.val;
                root = node.left;
            }
        }
        return result;
    }

}
