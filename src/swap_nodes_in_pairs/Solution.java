package swap_nodes_in_pairs;

import model.ListNode;

public class Solution {
	public static void main(String[] args) {
			ListNode l1 = new ListNode(1);
			ListNode l2 = new ListNode(2);
			ListNode l3 = new ListNode(3);
			ListNode l4 = new ListNode(4);
			l1.next = l2;
			l2.next = l3;
			l3.next = l4;
		ListNode head  =	swapPairs(l1);
		print(head);
}
	public static  void print(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode returnNode = head.next;
		ListNode previous = null;//记录上次交换节点的断节处 比如1，2，3，4 第一次记录的是1这个节点,
		ListNode swapa = head;
		ListNode swapb = null;
		ListNode nextStart = null;  //记录下次交换的点,比如1，2，3，4第一次记录的是3
		while(swapa != null  ){
			swapb = swapa.next;
			if(swapb == null){
				previous.next = swapa;
				break;
			}
			nextStart = swapb.next;
			swapb.next = swapa;
			swapa.next = null;
			if(previous != null){
				previous.next = swapb;
			}
			previous = swapa;
			swapa = nextStart;
		}
		return returnNode;
	}
}
