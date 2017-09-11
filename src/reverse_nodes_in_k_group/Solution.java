package reverse_nodes_in_k_group;

import model.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node = reverseKGroup(node2, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode next = head;
        while (next != null) {
            count++;
            next = next.next;
        }
        return reverseKGroup(head, k, count);

    }

    private static ListNode reverseKGroup(ListNode head, int k, int count) {
        if (count < k) {
            return head;
        }
        //after reverse, the head will be the tail, use to connect to the head of the next reversed group
        ListNode tail = head;
        ListNode next = head;
        ListNode previous = null;
        int cursor = 0;
        while (cursor++ < k) {
            ListNode node = next.next;
            next.next = previous;
            previous = next;
            next = node;
        }
        tail.next = reverseKGroup(next, k, count - k);
        return previous;
    }
}
