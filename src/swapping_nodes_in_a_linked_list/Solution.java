package swapping_nodes_in_a_linked_list;

import model.ListNode;
import tool.ListNodePrinter;

public class Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(7);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(7);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(0);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;

        ListNode head = swapNodes(node, 3);
        ListNodePrinter.print(head);
    }

    public static ListNode swapNodes(ListNode head, int k) {

        int count = 0;

        ListNode node = head;
        while (node != null) {
            node = node.next;
            count++;
        }

        int mid = count >> 1;
        if (k > mid) {
            k = count - k + 1;
        }
        node = head;
        ListNode swap = new ListNode(-1);
        for (int i = 1; i <= count; i++) {
            if (i == k) {
                swap = node;
            }
            if (i == count - k + 1) {
                int temp = node.val;
                node.val = swap.val;
                swap.val = temp;
                break;
            }
            node = node.next;
        }
        return head;
    }

}
