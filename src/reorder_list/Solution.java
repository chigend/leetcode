package reorder_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-06-24-10:23
 *
 * not a in-place solution,because it new a list that is reversed,there is no need to
 * reverse the whole list,just reverse list after middle.so see solution2
 */

public class Solution {
    private static int length;
    public static void main(String []args) {
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
        reorderList(null);
        while (node != null){
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
    }
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode tail = reverseList(head);
        int count = 0;
        while (count++ < length) {
            if ((count & 1) == 1) {
                ListNode next = head.next;
                head.next = tail;
                head = next;
                if (count == length-1) {
                    head = null;
                }
            }else {
                ListNode next = tail.next;
                tail.next = head;
                tail = next;
                if (count == length - 1){
                    tail = null;
                }
            }
        }

    }

    private static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode tail = null;
        while (head != null) {
            length++;
            tail = new ListNode(head.val);
            tail.next = previous;
            previous = tail;
            head = head.next;
        }
        return tail;
    }
}
