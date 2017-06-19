package add_one_row_to_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-06-19-19:14
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        TreeNode node = addOneRow(node1,1,3);
        System.out.print(node);
    }
    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
           TreeNode node = new TreeNode(v);
           node.left = root;
           return node;
        }
        convert(root,v,d,1);
        return root;
    }

    public static void convert(TreeNode root,int v,int d,int level) {
        if (root == null) return;
        if (level == d - 1) {
            TreeNode leftRoot = new TreeNode(v);
            TreeNode rightRoot = new TreeNode(v);
            leftRoot.left = root.left;
            rightRoot.right = root.right;
            root.left = leftRoot;
            root.right = rightRoot;
            return;
        }
        convert(root.left,v,d,level+1);
        convert(root.right,v,d,level+1);
    }


}
