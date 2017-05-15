package convert_sorted_list_to_binary_search_tree;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import model.ListNode;
import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-05-15-14:35
 */

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        TreeNode root = sortedListToBST(node1);
        traversal(root);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return convert(list,0,list.size()-1);
    }
    private static TreeNode convert(List<Integer>list,int start,int end){
        if (start < 0 || end >= list.size() || end < start) return null;
        int rootIndex = (start + end) >> 1;
        TreeNode root = new TreeNode(list.get(rootIndex));
        root.left = convert(list,start,rootIndex-1);
        root.right = convert(list,rootIndex+1,end);
        return root;
    }
    private static void traversal(TreeNode root) {
        if (root == null) return;
        traversal(root.left);
        System.out.print(root.val);
        traversal(root.right);
    }
}
