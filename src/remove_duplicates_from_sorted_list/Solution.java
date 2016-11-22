package remove_duplicates_from_sorted_list;

import model.ListNode;

public class Solution {
	public static void main(String[] args) {

	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode present = head.next;
		ListNode temp = head;//如果连续节点的val都相同,则temp表示该val值第一次出现的节点
		while(present != null){
			if(present.val != temp.val){
				temp.next = present;
				temp = present;
			}
			present = present.next;
		}
		temp.next = null;//如果末尾的连续节点的val值相同，则需要将第一次出现该值的节点的next属性置为null
		return head;
	}
}
