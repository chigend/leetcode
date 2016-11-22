package path_sum_II;

import java.util.ArrayList;
import java.util.List;

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
			List<List<Integer>> result = 	pathSum(t1,22);
			for(List<Integer> list : result){
				System.out.println(list);
			}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			def(result,list,root,sum);
			return result;
	}
	
	
	
	public static int caculateSum(List<Integer> list){
		int sum = 0;
		for(Integer i: list){
			sum += i;
		}
		return sum;
	}

	public static void def(List<List<Integer>>result,List<Integer>list,TreeNode root,int sum){
			if(root == null){
				return ;
			}
			list.add(root.val);//每次进入一个节点并将该节点的val压入栈
			if(root.left == null && root.right == null){  //当当前节点为leaf节点时，就计算sum值
				if(caculateSum(list) == sum){
					result.add(new ArrayList<Integer>(list));
	 			} 
				list.remove(list.size() - 1);//计算完将最后入栈的值出栈，因为该节点为leaf节点，无需继续向下挖掘。
				return ;
			}
			def(result,list,root.left,sum);
			def(result,list,root.right,sum);
			list.remove(list.size() -1);//每次遍历左右子节点后将当前节点的val出栈，其实两次pop是独立的(即运行了上面的pop就不会运行下面的pop)
			return ;
		}
}
