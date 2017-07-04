package insertion_sort_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-07-04-10:04
 */

public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
//        node2.next = node;
                node.next = node1;
                node1.next = node2;
        ListNode result = insertionSortList(node);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode next = head;
        ListNode present = head;
        ListNode last = null;
        while (next != null) {
            next = present.next;
            if (last == null || present.val >= last.val) {
                present.next = last;
                last = present;
            } else {
                ListNode previous = last;
                ListNode temp = last.next;
                while (temp != null && temp.val > present.val) {
                    temp = temp.next;
                    previous = previous.next;
                }
                previous.next = present;
                present.next = temp;
            }

            present = next;
        }
        return reverseList(last);
    }

    private static ListNode reverseList(ListNode tail) {
        ListNode next = tail;
        ListNode previous = null;
        while (next != null) {
            ListNode node = next;
            next = next.next;
            node.next = previous;
            previous = node;

        }
        return previous;
    }
}
