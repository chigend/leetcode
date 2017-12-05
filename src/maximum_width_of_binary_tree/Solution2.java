package maximum_width_of_binary_tree;

import java.util.Deque;
import java.util.LinkedList;

import model.TreeNode;

/**
 * bfs solution
 */
public class Solution2 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(9);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
//        node2.right = node5;
//        node3.right = node5;
//        node4.left = node6;
//        node5.right = node7;
        int width = widthOfBinaryTree(node);
        System.out.println(width);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> nodes = new LinkedList<>();
        Deque<Integer> indices = new LinkedList<>();
        nodes.add(root);
        indices.add(0);
        int max = 1;
        while (!nodes.isEmpty()) {
            max = Math.max(max, indices.getLast() - indices.getFirst() + 1);
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.pollFirst();
                int index = indices.pollFirst();
                if (node.left != null) {
                    nodes.offer(node.left);
                    indices.offer(2 * index + 1);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                    indices.offer(2 * index + 2);
                }
            }
        }
        return max;
    }

}
