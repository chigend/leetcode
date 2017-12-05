package kth_smallest_element_in_a_bst;

import java.util.Stack;

import model.TreeNode;

/**
 *  iterative solution
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }
            if (!nodes.isEmpty()) {
                root = nodes.pop();
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}
