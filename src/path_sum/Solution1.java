package path_sum;

import model.TreeNode;

public class Solution1 {
	public static void main(String[] args) {
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
			System.out.println(hasPathSum(t1,22));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		return 	dfs(root,sum,0);
	}
	

	public static boolean dfs(TreeNode root,int sum,int tempSum){
			if(root == null){
				return false;
			}
			//如果没有子节点，则以当前节点的sum来计算
			if(root.left == null && root.right == null){
				return tempSum+root.val == sum;
			}
			//如果有子节点(无论有1或者2个，都要以子节点返回的结果为准)
			boolean left = dfs(root.left,sum,tempSum+root.val);
			boolean right = dfs(root.right, sum,tempSum+root.val);
			
			return left||right;
		}
}


