package binary_tree_zigzag_level_order_traversal;

import model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yejinbiao
 * @create 2017-03-31-13:27
 */

public class Solution3 {
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
        List<List<Integer>> result = zigzagLevelOrder(node);
        System.out.print(result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversal(result,root,1);
        return result;
    }

    private static void traversal(List<List<Integer>> result,TreeNode root,int level) {
        if (root == null) return;
        if (result.size() < level) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        if (level % 2 == 0) {
            result.get(level - 1).add(0, root.val);
        }else {
            result.get(level - 1).add(root.val);
        }
        traversal(result,root.left,level+1);
        traversal(result,root.right,level+1);
    }
}
