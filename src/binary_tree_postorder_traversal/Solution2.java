package binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import model.TreeNode;

/**
 * a loop solution without recursion
 */

public class Solution2 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t.left = t2;
        List<Integer> result = postorderTraversal(t);
        System.out.println(result);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode lastVisted = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                /**
                 * for it is postorder traversal ,so not pop it immediately,
                 * when the right node of the current node is null or when
                 * the root.right == lastvisited (means the right node has been visited)
                 * visit it.
                 */
                root = stack.peek();
                if (root.right == null || root.right == lastVisted) {
                    stack.pop();
                    result.add(root.val);
                    lastVisted = root;
                    root = null; //if do not set null,it will sink in death loop
                } else {
                    root = root.right;
                }
            }
        }
        return result;
    }
}
