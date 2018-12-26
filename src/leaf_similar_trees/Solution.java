package leaf_similar_trees;

import java.util.Stack;

import model.TreeNode;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        Solution solution = new Solution();
        boolean similar = solution.leafSimilar(root, root);
        System.out.println(similar);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        traversal(root1, stack1);
        traversal(root2, stack2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (!stack1.pop().equals(stack2.pop())) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void traversal(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        traversal(root.left, stack);
        if (root.left == null && root.right == null) {
            stack.push(root.val);
        }
        traversal(root.right, stack);
    }


}
