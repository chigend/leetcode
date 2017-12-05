package binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-31-13:12
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
        List<List<Integer>> result = zigzagLevelOrder(node);
        System.out.print(result);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean fromHead = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (fromHead) {
                    list.add(node.val);
                }else {
                    list.add(0,node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(list);
            fromHead = !fromHead;
        }
        return result;
    }
}
