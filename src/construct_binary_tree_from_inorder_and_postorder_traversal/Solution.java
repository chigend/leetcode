package construct_binary_tree_from_inorder_and_postorder_traversal;

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-23-下午3:51
 */

public class Solution {
    private static Map<Integer, Integer> hash = new HashMap<>();

    public static void main(String[] args) {
        int [] inorder = {1};
        int [] postorder = {1};
        TreeNode node = buildTree(inorder,postorder);
        System.out.print(node);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }
        return constructTree(inorder, 0, inorder.length - 1, postorder, 0 ,postorder.length - 1);
    }

    private static TreeNode constructTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (istart > iend || pstart > pend) {
            return null;
        }
        int rootVal = postorder[pend];
        TreeNode root = new TreeNode(rootVal);
        int index = hash.get(rootVal);
        int leftSize = index - istart;
        root.left = constructTree(inorder, istart, index - 1, postorder, pstart, pstart + leftSize - 1);
        root.right = constructTree(inorder,index + 1, iend,postorder, pstart + leftSize, pend - 1);
        return root;
    }

}
