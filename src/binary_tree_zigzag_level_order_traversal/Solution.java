package binary_tree_zigzag_level_order_traversal;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author yejinbiao
 * @create 2017-03-31-12:10
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
        List<List<Integer>> result = zigzagLevelOrder(node);
        System.out.print(result);


    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        boolean fromHead = true;
        while (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = nodes.size();
            if (fromHead) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.remove(0);
                    list.add(node.val);
                    if (node.left != null) nodes.add(node.left);
                    if (node.right != null) nodes.add(node.right);
                }
            }else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.remove(nodes.size() - 1);
                    list.add(node.val);
                    if (node.right != null) nodes.add(0,node.right);
                    if (node.left != null) nodes.add(0,node.left);
                }
            }
            fromHead = !fromHead;
            result.add(list);
        }
        return result;
    }
}
