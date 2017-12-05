package validate_binary_search_tree;

import java.util.Stack;

import model.TreeNode;

/**
 * iterative solution
 */

public class Solution2 {
    public static void main(String[] args) {

    }
    public  boolean isValidBST(TreeNode root) {
        Stack<TreeNode> nodes = new Stack<>();
        Integer previous = null;
        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            if (!nodes.isEmpty()) {
                TreeNode node = nodes.pop();
                if (previous != null && node.val <= previous) {
                    return false;
                }
                previous = node.val;
                root = node.right;
            }
        }
        return true;
    }
}
