package find_mode_in_binary_search_tree;

import java.util.Arrays;

import model.TreeNode;

/**
 * O(1) space with two pass solution
 */

public class Solution3 {
    private static int modcount = 0;
    private static int max = 0;
    private static int count = 0;
    private static int current;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node.right = node2;
//        node2.left = node3;
        int [] modes = findMode(node);
        System.out.print(Arrays.toString(modes));
    }
    public static int[] findMode(TreeNode root) {
        //first pass count the max frequency a val appear, and the mode count
        count(root);
        count = 0;
        current = 0;
        int [] result = new int[modcount];
        //the second pass to collect the val which is equal to the max frequency count
        collect(root,result);
        return result;
    }


    private static void count(TreeNode root) {
        if (root == null) return;
        count(root.left);
        if (root.val != current) {
            current = root.val;
            count = 0;
        }
        count++;
        if (count == max) {
            modcount++;
        } else if (count > max) {
            max = count;
            modcount = 1;
        }
        count(root.right);
    }

    private static void collect(TreeNode root, int [] nums) {
        if (root == null) return ;
        collect(root.left,nums);
        if (root.val != current){
            current = root.val;
            count = 0;
        }
        count++;
        if (count == max) nums[--modcount] = root.val;
        collect(root.right,nums);
    }
}
