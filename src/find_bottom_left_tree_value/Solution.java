package find_bottom_left_tree_value;

import model.TreeNode;

/**
 *  a recursion solution
 */

public class Solution {
    private static int leftMostValue = 0;
    private static int maxLevel = 0;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;
//        node3.right = node4;
        int left = findBottomLeftValue(node);
        System.out.print(left);
    }

    public static int findBottomLeftValue(TreeNode root) {
        traversal(root, 1);
        return leftMostValue;
    }

    /***
     * 因为遍历顺序是从左向右的，所以只要该层有一个节点已经赋值最左的值，那么该层的其他值都直接跳过 即level > maxLevel
     * @param root
     * @param level
     */
    private static void traversal(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel && root.left == null && root.right == null ) {
            leftMostValue = root.val;
            maxLevel = level;
        }
        level++;
        traversal(root.left, level);
        traversal(root.right, level);
    }
}
