package insertion_sort_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-07-04-10:58
 */

public class Solution2 {
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
        ListNode fakeHead = new ListNode(-1);
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            ListNode previous = fakeHead;
            next = current.next;
            while (previous.next != null && previous.next.val < current.val) {
                previous = previous.next;
            }
            current.next = previous.next;
            previous.next = current;

            current = next;
        }
        return fakeHead.next;
    }
}
