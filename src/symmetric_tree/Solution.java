package symmetric_tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * a iterative solution without recursion
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(3);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        boolean isSymmetric = isSymmetric(node);
        System.out.print(isSymmetric);
//        List<TreeNode> nodes = new ArrayList<>();
//        nodes.add(null);
//        nodes.add(null);
//        System.out.print(nodes);

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            int low = 0;
            int high = size - 1;
            while (low < high) {
                TreeNode head = nodes.get(low++);
                TreeNode tail = nodes.get(high--);
                if (head == null && tail == null) {
                    continue;
                }
                if (head == null || tail == null) {
                    return false;
                }
                if (head.val != tail.val) {
                    return false;
                }
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove(0);
                if (node == null) {
                    continue;
                }
                nodes.add(node.left);
                nodes.add(node.right);
            }
        }
        return true;
    }
}
