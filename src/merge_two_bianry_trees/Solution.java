package merge_two_bianry_trees;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-06-11-16:55
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(3);
        TreeNode node13 = new TreeNode(2);
        TreeNode node14 = new TreeNode(5);
        node11.left = node12;
        node11.right = node13;
        node12.left = node14;
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(1);
        TreeNode node23 = new TreeNode(3);
        TreeNode node24 = new TreeNode(4);
        TreeNode node25 = new TreeNode(7);
        node21.left = node22;
        node21.right = node23;
        node22.right = node24;
        node23.right = node25;
        TreeNode root = mergeTrees(node11, node21);
        System.out.println(root);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode root = new TreeNode(t1.val+t2.val);
        root.left = mergeTrees(t1.left,t2.left);
        root.right = mergeTrees(t1.right,t2.right);
        return root;
    }
}
