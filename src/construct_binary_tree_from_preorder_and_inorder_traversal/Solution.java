package construct_binary_tree_from_preorder_and_inorder_traversal;

import java.util.HashMap;
import java.util.Map;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-23-下午2:26
 */

public class Solution {
    public static void main(String[] args) {
        int [] preorder = {1,2};
        int [] inorder = {2,1};
        TreeNode root = buildTree(preorder, inorder);
        System.out.print(root.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            //store the position of every number in inorder traversal
            hash.put(inorder[i],i);
        }

        return constructTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, hash);
    }
    private static TreeNode constructTree(int[] preorder, int plow, int phigh, int[] inorder, int ilow, int ihigh,Map<Integer, Integer> hash) {
        if (plow > phigh || ilow > ihigh) return null;
        int rootVal = preorder[plow];
        int index = hash.get(rootVal);
        int leftSize = index - ilow;
        TreeNode root = new TreeNode(rootVal);
        root.left = constructTree(preorder, plow + 1, plow + leftSize, inorder, ilow, index - 1, hash);
        root.right = constructTree(preorder, plow + leftSize + 1, phigh, inorder, index + 1, ihigh, hash);
        return root;
    }

}
