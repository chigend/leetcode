package range_sum_of_bst;

import java.time.temporal.ValueRange;

import model.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode root2 = new TreeNode(5);
        TreeNode root3 = new TreeNode(15);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(18);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.right = root6;
        int i = rangeSumBST(root, 7, 15);
        System.out.println(i);
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
