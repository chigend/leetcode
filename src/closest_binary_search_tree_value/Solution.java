package closest_binary_search_tree_value;

import model.Node;
import model.TreeNode;
import tool.TreeNodeTestCaseTransformer;

public class Solution {

    private static double minDiff ;

    private static int val;

    public static void main(String[] args) {
        TreeNode node = TreeNodeTestCaseTransformer.transformTreeNode("[1]");
        System.out.println(closestValue(node, 3.714286));
    }

    public static int closestValue(TreeNode root, double target) {
        minDiff = Double.MAX_VALUE;
        closestValue0(root, target);
        return val;
    }

    public static boolean closestValue0(TreeNode root, double target) {
        if (root == null) {
            return true;
        }

        boolean continued = closestValue0(root.left, target);
        if (!continued) {
            return false;
        }
        if (Math.abs(target - root.val) < minDiff) {
            minDiff = Math.abs(target - root.val);
            val = root.val;
        } else {
            return false;
        }
        return closestValue0(root.right, target);
    }
}
