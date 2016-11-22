package odd_even_linked_list;

import java.awt.Event;

import model.ListNode;

public class Solution {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
//		l3.next = l4;
		ListNode head = oddEvenList(l1);
		print(head);
		
	}
	public static void print(ListNode head){
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode oddEvenList(ListNode head) {
			if(head == null || head.next ==null){
				return head;
			}
			ListNode odd = head;
			ListNode even = head.next;
			
			ListNode connect = even;
			while( true){
				if(odd.next == null || even.next == null){
					odd.next = connect;
					break;
				}
				odd.next = even.next;
				odd = odd.next;
				even.next = odd.next;
				even = even.next;
			}
			return head;
			
	}
}
