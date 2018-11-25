package increasing_order_search_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

import model.TreeNode;

public class Solution2 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(1);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node7;
        node3.right = node6;
        node6.left = node8;
        node6.right = node9;
        Solution2 solution = new Solution2();
        TreeNode root = solution.increasingBST(node);
        System.out.println(root.val);

    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(root, nodes);
        TreeNode fake = new TreeNode(-1);
        TreeNode head = fake;
        for (int val : nodes) {
            head.right = new TreeNode(val);
            head = head.right;
        }
        return fake.right;
    }

    private void traversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        traversal(root.left, nodes);
        nodes.add(root.val);
        traversal(root.right, nodes);
    }
}
