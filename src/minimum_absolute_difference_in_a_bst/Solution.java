package minimum_absolute_difference_in_a_bst;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-24-下午5:57
 */

public class Solution {
    private static int minDifference ;
    private static Integer previous = null;
    public static void main(String[] args) {

    }

    public static int getMinimumDifference(TreeNode root) {
        previous = null;
        minDifference = Integer.MAX_VALUE;
        getMinDifference(root);
        return minDifference;
    }

    private static void getMinDifference(TreeNode root) {
        if (root == null) return;
        getMinDifference(root.left);
        if (previous != null && root.val - previous < minDifference) minDifference = root.val - previous;
        previous = root.val;
        getMinDifference(root.right);
    }

}
