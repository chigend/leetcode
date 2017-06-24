package subtree_of_another_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-06-24-8:42
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(1);
        TreeNode node23 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node21.left = node22;
        node21.right = node23;

        boolean flag = isSubtree(node1,node21);
        System.out.print(flag);


    }
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSame(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    private static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSame(p.left,q.left) && isSame(p.right,q.right);
    }
}
