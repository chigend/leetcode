package binary_tree_path;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
			TreeNode t10 = new TreeNode(5);
			t1.left = t2;
			t1.right = t3;
			t2.left = t4;
			t4.left = t7;
			t4.right = t8;
			t3.left = t5;
			t3.right = t6;
			t6.left = t10;
			t6.right = t9;
		List<String>  paths = 	binaryTreePaths(t1);
		System.out.println(paths);
		}
		public static List<String> binaryTreePaths(TreeNode root) {
			List<String> result = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			searchPath(result,sb,root,0);
			return result;
	    }
		
		public static void searchPath(List<String >result,StringBuilder sb,TreeNode root,int level){
			if(root == null){
				return;
			}
			int backLen = 0;//定义节点出栈回退字符串的长度
			if(level == 0){
				sb.append(root.val);
				backLen = String.valueOf(root.val).length();
			}else{
				sb.append("->").append(root.val);
				backLen = String.valueOf(root.val).length()+2;
			}
			if(root.left == null && root.right == null){
				result.add(sb.toString());
				//每次到达leaf节点时，就要回退字符串,将sb的末尾的backLen长度的字符串删除
				sb.delete(sb.length() -backLen, sb.length());
				
				return;
			}
			searchPath(result,sb,root.left,level+1);
			searchPath(result, sb, root.right,level+1);
			//同理，每次该节点的子节点都遍历完，也要回退字符串，将sb的末尾的backLen长度的字符串删除
			sb.delete(sb.length() -backLen, sb.length());
			return;
		}
}
