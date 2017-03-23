package binary_tree_right_side_view;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-23-下午8:45
 */

public class Solution {
    private static List<Integer> result;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        node.right = node2;
//        node.right = node3;
//        node2.right = node4;
//        node3.right = node5;
        List<Integer> result = rightSideView(node);
        System.out.print(result);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        traversal(root, 1);
        return result;
    }

    private static void traversal(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > result.size()) result.add(root.val);

        traversal(root.right, level + 1);
        traversal(root.left, level + 1);

    }
}
