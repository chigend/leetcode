package sort_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-06-24-12:38
 */

public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        ListNode head = sortList(node);
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }

    }
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return  head;
        ListNode mid = findMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        left = sortList(left);
        right = sortList(right);
        return mergeTwoList(left,right);
    }


    private static ListNode mergeTwoList(ListNode left,ListNode right) {
        if (left == null && right == null) return null;
        ListNode fakeHead = new ListNode(-1);
        ListNode present = fakeHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                present.next = left;
                left = left.next;
            }else {
                present.next = right;
                right = right.next;
            }
            present = present.next;
        }
        if (left == null) present.next = right;
        if (right == null) present.next = left;
        return fakeHead.next;
    }

    private static ListNode findMiddle(ListNode head) {

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
