package merge_two_sorted_lists;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-06-24-13:36
 */

public class Solution3 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(10);
        ListNode l15 = new ListNode(15);
        ListNode l16 = new ListNode(16);
        ListNode l17 = new ListNode(20);

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(5);
        ListNode l24 = new ListNode(6);
        ListNode l25 = new ListNode(17);
        ListNode l26 = new ListNode(21);
        ListNode l27 = new ListNode(22);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        l21.next = l22;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        ListNode head = mergeTwoLists(l11, l21);
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if (n1 == null && n2 == null) return null;
        ListNode fakeHead = new ListNode(-1);
        ListNode present = fakeHead;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                present.next = n1;
                n1 = n1.next;
            }else {
                present.next = n2;
                n2 = n2.next;
            }
            present = present.next;
        }
        if (n1 == null) present.next = n2;
        if (n2 == null) present.next = n1;
        return fakeHead.next;
    }
}
