package remove_nth_node_from_end_of_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-07-下午5:23
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode head = removeNthFromEnd(l,2);
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        ListNode present = head;
        int length = 0;
        while (present != null) {
            length++;
            present = present.next;
        }
        if (length == 0) {
            return null;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode previous = fakeHead;
        present = head;
        int count = 0;
        while (count++ < length - n) {
            previous = present;
            present = present.next;
        }
        previous.next = present.next;
        return fakeHead.next;
    }
}
