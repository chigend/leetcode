package lowest_common_ancestor_of_a_binary_search_tree;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-05-24-11:06
 */

public class Solution {
    public static void main(String[] args) {
        TreeNode node  = new TreeNode(6);
        TreeNode node2  = new TreeNode(2);
        TreeNode node3  = new TreeNode(8);
        TreeNode node4  = new TreeNode(0);
        TreeNode node5  = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7  = new TreeNode(9);
        TreeNode node8  = new TreeNode(3);
        TreeNode node9  = new TreeNode(5);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        TreeNode ancestor = lowestCommonAncestor(node,node2,node5);
        System.out.print(ancestor.val);
    }

    /**
     * 因为bst是按照值的大小构造的，即左节点的值比父节点小。右节点的值比父节点的大，
     * 那么如果当前节点的值比两个节点的值都大，那么两个节点的最近的祖先一定是在左子树中（包括两个节点本身）
     * 那么如果当前节点的值比两个节点的值都小，那么两个节点的最近的祖先一定是在右子树中（包括两个节点本身）
     * 如果当前节点大于等于一个节点的值 小于等于另外一个点，那么当前这个节点就是该两个节点的祖先（如果出现这种情况，一个节点
     * 是属于当前节点的左子树，另外一个节点一定属于当前节点的右子树，那么如果当前节点不是最近的节点，那么就再也找不到祖先
     * 节点了，因为已经分叉开了）
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
