package maximum_binary_tree;

import model.TreeNode;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2};
        TreeNode root = constructMaximumBinaryTree(nums);
        System.out.println(root);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(0, nums.length - 1, nums);
    }

    public static TreeNode constructMaximumBinaryTree(int start, int end, int[] nums) {
        int index = findMax(start, end, nums);
        if (index == -1) {
            return null;
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(start, index - 1, nums);
        node.right = constructMaximumBinaryTree(index + 1, end, nums);
        return node;
    }

    private static int findMax(int start, int end, int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
