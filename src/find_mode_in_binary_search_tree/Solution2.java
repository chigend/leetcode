package find_mode_in_binary_search_tree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

public class Solution2 {
    private static Integer previous;
    private static int maxCount = 0;
    private static int count = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
//        node.right = node2;
//        node2.left = node3;
        int[] nums = findMode(node);
        System.out.print(Arrays.toString(nums));
    }

    public static int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        int[] nums = new int[result.size()];
        for (int i = 0; i < nums.length; i++) nums[i] = result.get(i);
        return nums;
    }

    private static void traversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        traversal(root.left, result);
        if (previous == null) {
            previous = root.val;
        }
        if (root.val == previous) {
            count++;

        } else {
            previous = root.val;
            count = 1;
        }
        if (count > maxCount) {
            /**
             * once we meet a count that is larger than the maxcount, it means the result add before
             * is not the max ,so clear it,and add the new max count val
             */
            result.clear();
            result.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            /**
             * wheneven meet a val that it's count equal to the maxcount ,we add it
             */
            result.add(root.val);
        }
        traversal(root.right, result);
    }

}
