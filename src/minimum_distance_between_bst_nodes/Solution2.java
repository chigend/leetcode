package minimum_distance_between_bst_nodes;

import java.util.Stack;

import model.TreeNode;

/**
 * iterative solution
 */
public class Solution2 {
    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int min = 2147483647;
        Integer pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (pre != null) {
                    min = Math.min(min, node.val - pre);
                }
                pre = node.val;
                root = node.right;
            }
        }
        return min;
    }
}
