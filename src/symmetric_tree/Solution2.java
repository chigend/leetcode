package symmetric_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-17-下午12:48
 */

public class Solution2 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(3);
//        node.left = node2;
//        node.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        node.left = node6;
        node.right = node2;
        boolean isSymmetric = isSymmetric(node);
        System.out.print(isSymmetric);
    }
    public  static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return traversal(root.left, root.right);
    }
    public static boolean traversal(TreeNode left, TreeNode right) {
        /**
         * 如果想对应的两个节点都为null，则该亮点对称，并无须比较其子节点
         */
        if (left == null && right == null) return true;
        /**
         *  如果相对应的两个节点其中一个是null，则这两个节点不对称，返回false
         */
        if (left == null || right == null) return false;
        /**
         * 如果两个节点都不为null，并且两个节点的值不相等，则这两个节点不对称，返回false
         */
        if (left.val != right.val) return false;
        /**
         * 如果当前节点对称，则递归比较其子节点是否对称，比如：
         *        1
         *       2  2
         *     1 4  4 1
         *
         *    在第二层左节点2和右节点2对称后 需比较左节点的left与右节点的right（即1和1两个节点）是否对称
         *    同时也要比较左节点的right和又节点的left（即4和4）是否对称。 并且都对称才返回true 所以用&逻辑
         */
        return traversal(left.left, right.right) && traversal(left.right, right.left);
    }
}
