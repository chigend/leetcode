package convert_sorted_array_to_binary_search_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-30-16:00
 */

public class Solution {
    public static void main(String[] args) {
        int []sortedArray = {1,2,3};
        TreeNode root = sortedArrayToBST(sortedArray);
        System.out.print(root);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return constructNode(nums,0,nums.length-1);

    }

    private static TreeNode constructNode(int[]nums, int start, int end) {
        if (start >= nums.length ||start > end) return null;
        int rootIndex = (start + end) >> 1;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = constructNode(nums,start, rootIndex - 1);
        root.right = constructNode(nums, rootIndex + 1, end);
        return root;
    }
}
