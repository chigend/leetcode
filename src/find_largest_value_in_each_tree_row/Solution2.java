package find_largest_value_in_each_tree_row;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * a loop solution without recursion
 */

public class Solution2 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.left = t5;
        t3.right = t6;
        List<Integer> largestValues = largestValues(t1);
        System.out.println(largestValues);
    }


    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> largestValues = new ArrayList<>();
        if (root == null) {
            return largestValues;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Integer maxValue = Integer.MIN_VALUE;
            int size = nodes.size();
            for (int i = 0;i < size; i++) {
                TreeNode node = nodes.remove(0);
                maxValue = Math.max(node.val, maxValue);
                if (node.left != null){
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            largestValues.add(maxValue);
        }
        return largestValues;
    }


}
