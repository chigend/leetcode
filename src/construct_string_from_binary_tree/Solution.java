package construct_string_from_binary_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-06-09-10:39
 */

public class Solution {
    public static void main (String[] t) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        node1.right = new TreeNode(4);
        String s = tree2str(root);


        System.out.println(s);
    }

    public static String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        convert(t,sb);
        return sb.toString();
    }

    private static void convert(TreeNode root,StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        //if it's a leaf node,there is no need to display it's empty childs
        if (root.left == null && root.right == null)return;
        sb.append('(');
        convert(root.left,sb);
        sb.append(')');
        //since empty right child node can be left,so we add not null condition
        if (root.right != null) {
            sb.append('(');
            convert(root.right,sb);
            sb.append(')');
        }
    }

}
