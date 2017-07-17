package average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.TreeNode;

/**
 * iterative solution
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
        List<Double> s = averageOfLevels(node);
        System.out.println(s);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.removeFirst();
                sum += node.val;
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            res.add(sum/size);

        }
        return res;
    }
}
