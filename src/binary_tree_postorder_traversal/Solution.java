package binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * a recursion solution
 */

public class Solution {
    public static void main(String [] args) {

    }


    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(TreeNode root,List<Integer> result) {
        if (root == null) {
            return ;
        }
        traversal(root.left, result);
        traversal(root.right, result);
        result.add(root.val);
    }
}
