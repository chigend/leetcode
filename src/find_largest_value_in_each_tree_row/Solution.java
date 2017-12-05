package find_largest_value_in_each_tree_row;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-14-下午8:21
 */

public class Solution {
    private static List<Integer> largestValues = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.left = t5;
        t3.right = t6;
        largestValues(t1);
        System.out.println(largestValues);
    }

    public static List<Integer> largestValues(TreeNode root) {
         traversal(root, 1);
         return largestValues;
    }

    private static void traversal(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (largestValues.size() < level) {
            largestValues.add(root.val);
        } else {

            largestValues.set(level-1, Math.max(root.val,largestValues.get(level-1)));
        }
        level++;
        traversal(root.left, level);
        traversal(root.right, level);
    }
}
