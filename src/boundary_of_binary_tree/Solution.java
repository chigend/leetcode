package boundary_of_binary_tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-03-26-10:26
 */

public class Solution {
    private  TreeNode leftMost;
    private  TreeNode rightMost;
    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node10 = new TreeNode(10);
//        node.left = node2;
//        node.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node5.left = node7;
//        node5.right = node8;
//        node3.left = node6;
//        node6.left = node9;
//        node6.right = node10;
        TreeNode node = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node.left = node2;
//        node2.left = node3;
//        node2.right = node4;



//        System.out.println(boundaryOfBinaryTree(node));

    }
    //todo

    public  List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        leftBoundary(root.left, result);
        if (root.left != null || root.right != null) leavesBoundary(root, result);
        rightBoundary(root.right, result);
        return result;
    }

    private  void leftBoundary(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        leftMost = root;
        leftBoundary(root.left, result);
        if (root.left == null) leftBoundary(root.right, result);

    }

    private  void rightBoundary(TreeNode root, List<Integer> result) {
        if (root == null) return;
        rightBoundary(root.right, result);
        if (root.right == null) rightBoundary(root.left, result);
        if (root != rightMost) result.add(root.val);
    }

    private  void leavesBoundary(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null){
            if (root != leftMost) result.add(root.val);
            rightMost = root;
        }
        leavesBoundary(root.left, result);
        leavesBoundary(root.right, result);
    }
}
