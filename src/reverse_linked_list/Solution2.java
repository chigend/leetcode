package reverse_linked_list;

import model.ListNode;

public class Solution2 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(10);
        ListNode l15 = new ListNode(15);
        ListNode l16 = new ListNode(16);
        ListNode l17 = new ListNode(20);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        ListNode head = reverseList(l11);
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        reverseList(head, fakeHead);
        return fakeHead.next;
    }

    public static ListNode reverseList(ListNode head, ListNode fakeHead) {
        if (head == null) {
            return fakeHead;
        }

        ListNode next = reverseList(head.next, fakeHead);
        head.next = null;
        next.next = head;
        return head;
    }
}
