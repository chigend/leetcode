package binode;

import java.util.Stack;

import model.TreeNode;
import tool.TreeNodeTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeTestCaseTransformer.transformTreeNode("[4,2,5,1,3,null,6,0]");
        TreeNode treeNode1 = convertBiNode(treeNode);
        System.out.println(treeNode1);
    }

    public static TreeNode convertBiNode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode fake = new TreeNode(-1);
        TreeNode previous = fake;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                previous.left = null;
                previous.right = node;
                previous = node;
                root = node.right;
            }
        }
        previous.left = null;
        return fake.right;
    }
}
