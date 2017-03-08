package reverse_linked_list_II;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-08-下午2:23
 */

public class Solution {
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
        ListNode head = reverseBetween(null, 0,0);
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        int count = 1;
        ListNode nodeBeforeReverse = fakeHead;
        ListNode startOfReverse = null;
        ListNode present = head;
        ListNode previous = null;
        while (count  <= n ) {
            if (count < m ) {
                nodeBeforeReverse = present;
                present = present.next;
            }else {
                if (count == m) {
                    startOfReverse = present;
                }
                ListNode temp = present.next;
                present.next = previous;
                previous = present;
                present = temp;
            }
            count ++;
        }
        ListNode nodeAfterReverse = present;
        ListNode endOfReverse = previous;
        startOfReverse.next = nodeAfterReverse;
        nodeBeforeReverse.next = endOfReverse;
        return fakeHead.next;
    }
}
