package binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

/**
 * a recursion solution
 */
public class Solution1 {
		public static void main(String [] args){
			
		}
		
		public static List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
	        traversal(result,root);
	        return result;
	    }
		
		public static void traversal(List<Integer> result,TreeNode root){
			if(root == null){
				return ;
			}
			result.add(root.val);
			traversal(result,root.left);
			traversal(result,root.right);
		}
}
