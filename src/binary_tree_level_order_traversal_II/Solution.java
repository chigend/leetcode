package binary_tree_level_order_traversal_II;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-17-上午10:13
 */

public class Solution {
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
        List<List<Integer>> result = levelOrderBottom(node);
        System.out.print(result);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        traversal(root,1, result);
        return result;
    }
    private static void traversal(TreeNode root,int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level > result.size()) {
            result.add(0,new ArrayList<>());
        }
        traversal(root.left,level + 1,result);
        traversal(root.right,level + 1,result);
        result.get(result.size() - level).add(root.val);
    }
}
