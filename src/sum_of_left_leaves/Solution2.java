package sum_of_left_leaves;

import java.util.Stack;

import model.TreeNode;

/**
 * a loop solution without recursion
 */

public class Solution2 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node.left = node2;
        node.right = node3;
        node3.left = node4;
        node3.right = node5;
        int leafLeaveSum = sumOfLeftLeaves(node);
        System.out.print(leafLeaveSum);

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack =  new Stack<>();
        int sum = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                if (!stack.isEmpty()) {
                    //get the previous node in the stack
                    TreeNode previous = stack.peek();
                    /**
                     * if the current node is the left node of previous node
                     * and the current node is the leaf node, add the current's node value
                     */
                    if (root.left == null && root.right == null && previous.left == root) {
                        sum += root.val;
                    }
                }
                root = root.right;
            }
        }
        return sum;
    }
}
