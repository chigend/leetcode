package closest_binary_search_tree_value;

import java.util.Stack;

import model.Node;
import model.TreeNode;

public class Solution2 {

    public static void main(String[] args) {

    }

    public static int closestValue(TreeNode root, double target) {

        Stack<TreeNode> stack = new Stack<>();

        double min = Double.MAX_VALUE;
        int val = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            if (Math.abs(node.val - target) < min) {
                min = Math.abs(node.val - target);
                val = node.val;
            }

            root = node.right;

        }
        return val;
    }
}
