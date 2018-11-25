package increasing_order_search_tree;

import model.TreeNode;

public class Solution {
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
        Solution solution = new Solution();
        TreeNode root = solution.increasingBST(node);
        System.out.println(root.val);

    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] result = orderBST(root);
        return result == null ? null : result[0];
    }

    public TreeNode[] orderBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[]{root, root};
        TreeNode[] leftNodes = orderBST(root.left);
        TreeNode[] rightNodes = orderBST(root.right);
        if (leftNodes != null) {
            leftNodes[1].right = root;
            nodes[0] = leftNodes[0];
        }
        if (rightNodes != null) {
            root.right = rightNodes[0];
            nodes[1] = rightNodes[1];
        }
        root.left = null;
        return nodes;
    }
}
