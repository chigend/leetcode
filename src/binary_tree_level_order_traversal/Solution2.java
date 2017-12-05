package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;
//递归的写法
public class Solution2 {
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
			List<List<Integer>> result = 	levelOrder(t1);
			for(List<Integer> list : result){
				System.out.println(list);
			}
	}
	
	public static  List<List<Integer>> levelOrder(TreeNode root){
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 traversal(result,root,0);
		 return result;
	}
	
	public static void traversal(List<List<Integer>> result,TreeNode root,int level){
		if(root == null){
			return ;
		}
		//按层次在result里存取，如果已经存在，则直接在result里取出当前level的list，并存入当前节点的val
		if(result.size() > level&&result.get(level) != null){
			result.get(level).add(root.val);
		}else{
			//如果result没有该层的list，则新建一个list，将当前节点的val插入到list之后，并将list按照层数去插入到result中
			List<Integer> levelList = new ArrayList<Integer>();
			levelList.add(root.val);
			result.add(level, levelList);
		}
		traversal(result,root.left,level+1);
		traversal(result,root.right,level+1);
	}
}
