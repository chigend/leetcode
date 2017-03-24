package minimum_absolute_difference_in_a_bst;

import model.TreeNode;

import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-24-下午7:35
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Integer previous = null;
        int min = Integer.MAX_VALUE;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (previous != null && node.val - previous < min) min = node.val - previous;
                previous = node.val;
                root = node.right;
            }
        }
        return min;
    }
}
