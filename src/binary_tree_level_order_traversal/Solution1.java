package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;
//普通遍历
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
		List<List<Integer>> ss= levelOrder(t1);
		for(List<Integer> ll : ss){
			System.out.println(ll);
		}
		
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();
		List<List<Integer>> val = new ArrayList<List<Integer>>();
		if(root == null){
			return new ArrayList<List<Integer>>() ;
		}
		List<TreeNode> rootList = new ArrayList<TreeNode>();
		rootList.add(root);
		result.add(rootList);
		int depth = 1;
		//将节点按照层次存放到List中，最后再遍历节点的集合，将其值存入另一个List中
		while(result.size() >= depth ){
			List<TreeNode> list = result.get(result.size() - 1);
			List<TreeNode> levelList = new ArrayList<TreeNode>();
			for(TreeNode node : list){
				if(node.left != null){
					levelList.add(node.left);
				}
				if(node.right != null){
					levelList.add(node.right);
				}
			}
			if(levelList.size() != 0){
				result.add( levelList);
			}
			depth ++;
		}
		for(int i = 0;i < result.size();i++){
			List<TreeNode> tl = result.get(i);
			List<Integer>  vl = new ArrayList<Integer>();
			for(TreeNode node:tl){
				vl.add(node.val);
			}
			val.add(vl);
		}
		return val;
		
		
	}
}
