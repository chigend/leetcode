package minimun_depth_of_binary_tree;

import model.TreeNode;
//recursion solution
public class Solution {
	public static void main(String [] args){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;
//		TreeNode t1 = new TreeNode(5);
//		TreeNode t2 = new TreeNode(4);
//		TreeNode t3 = new TreeNode(8);
//		TreeNode t4 = new TreeNode(11);
//		TreeNode t5 = new TreeNode(13);
//		TreeNode t6 = new TreeNode(4);
//		TreeNode t7 = new TreeNode(7);
//		TreeNode t8 = new TreeNode(2);
//		TreeNode t9 = new TreeNode(1);
//		TreeNode t10 = new TreeNode(5);
//		t1.left = t2;
//		t1.right = t3;
//		t2.left = t4;
//		t4.left = t7;
//		t4.right = t8;
//		t3.left = t5;
//		t3.right = t6;
//		t6.left = t10;
//		t6.right = t9;
		int minDepth = minDepth(t1);
		System.out.println(minDepth);
	}
	public static int minDepth(TreeNode root){
		return dfs(root,1);
	}
	public static int dfs(TreeNode root,int level){
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return  level;
		}
		
		int leftDepth = dfs(root.left,level+1);
		int rightDepth = dfs(root.right,level+1);
		//如果左子树为null，则返回右节点的最小值
		if(leftDepth == 0){
			return rightDepth;
		}
		//如果右子树为null，则返回左节点的最小值
		if(rightDepth == 0){
			return leftDepth;
		}
	
		return Math.min(leftDepth, rightDepth);
		
	}
}
