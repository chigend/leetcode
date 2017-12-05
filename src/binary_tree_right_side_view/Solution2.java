package binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-23-下午9:46
 */

public class Solution2 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(4);
        node.left = node2;
        node.right = node3;
        node2.right = node4;
        node3.right = node5;
        List<Integer> result = rightSideView(node);
        System.out.print(result);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            result.add(nodes.get(size - 1).val);
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.remove(0);
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);
            }
        }
        return result;
    }
}
