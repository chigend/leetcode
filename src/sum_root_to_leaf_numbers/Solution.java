package sum_root_to_leaf_numbers;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-18-下午4:12
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.left = node2;
        node.right = node3;
        int sum = sumNumbers(node);
        System.out.print(sum);
    }

    public static int sumNumbers(TreeNode root) {
        return traversal(root, 0);
    }

    public static int traversal(TreeNode root, int pathNum) {
        if (root == null) {
            return 0;
        }

        /**
         * 计算出当前节点的pathNum，
         * 如果当前节点为叶子节点，就返回当前的pathNum
         */
        pathNum = pathNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return pathNum;
        }
        /**
         * 如果当前节点还有子节点那么当前节点的pathNum就不能拿来计算
         *
         * 对于每个节点，都计算出其左右子节点的pathNum的和
         */
        return traversal(root.left,pathNum) + traversal(root.right, pathNum);
    }
}
