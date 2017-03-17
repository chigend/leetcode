package binary_tree_inorder_traversal;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * a recursion solution
 */
public class Solution1 {
	public static void main(String [] args){
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(4);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(11);
		TreeNode t5 = new TreeNode(13);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(2);
		TreeNode t9 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.left = t7;
		t4.right = t8;
		t3.left = t5;
		t3.right = t6;
		t6.right = t9;
		List<Integer> result = inorderTraversal(t1);
		System.out.println(result);
	}
	public static List<Integer> inorderTraversal(TreeNode root) {
		
		List<Integer> result = new ArrayList<Integer>();
		traversal(result,root);
		return result;
		
		
	}
	public static void traversal(List<Integer>result,TreeNode root){
		if(root == null){
			return;
		}
		traversal(result,root.left);
		result.add(root.val);
		traversal(result,root.right);
	}
}
