package delete_node_in_a_linked_list;

import model.ListNode;

public class Solution {
	public static void main(String [] args){
	}
	 public void deleteNode(ListNode node) {
	        if(node == null || node.next == null){
	            return;
	        }
	        ListNode previous = null;
	        ListNode next = null;
	        ListNode present = node;
	        while(present != null){
	        	next = present.next;
	            if(next == null){
	            	previous.next = null;
	                break;
	            }
	            present.val = present.next.val;
	            
	            previous = present;
	            present = next;
	            
	        }
	    }
}
