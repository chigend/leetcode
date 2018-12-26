package leaf_similar_trees;

import java.util.Stack;

import model.TreeNode;

public class Solution2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        Solution2 solution = new Solution2();
        boolean similar = solution.leafSimilar(root, root);
        System.out.println(similar);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            if (nextLeaf(stack1) != nextLeaf(stack2)) {
                return false;
            }
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private int nextLeaf(Stack<TreeNode> stack) {
        while (true) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.left == null && node.right == null) {
                return node.val;
            }
        }
    }

}
