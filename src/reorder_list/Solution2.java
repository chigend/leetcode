package reorder_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-06-24-11:17
 */

public class Solution2 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
//        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
        reorderList(node);
        while (node != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
    }

    public static   void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = findMiddle(head);
        //reverse list after middle
        ListNode tail = reverseList(mid.next);
        //set mid.next to null to cut the list into two parts
        mid.next = null;
        //link the head list and the tail list(the tail is reversed) one by one
        while (head != null && tail != null) {
            ListNode headTemp = head.next;
            ListNode tailTemp = tail.next;
            tail.next = head.next;
            head.next = tail;
            head = headTemp;
            tail = tailTemp;
        }


    }
    private static ListNode findMiddle(ListNode head) {
        ListNode tail = head.next.next;
        ListNode mid = head;
        while (tail != null) {
            mid = mid.next;
            tail = tail.next;
            if(tail != null) tail = tail.next;
        }
        return mid;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode next = head;
        while (next != null) {
            ListNode temp = next.next;
            next.next = previous;
            previous = next;
            next = temp;
        }
        return previous;
    }
}
