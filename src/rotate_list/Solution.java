package rotate_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-08-上午9:43
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(6);
//        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode head = rotateRight(l4,1);
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode present = head;
        ListNode last = null;
        while (present != null) {
            //get the length of the list
            length++;
            //get the last node of the list
            last = present;
            present = present.next;
        }
        int steps = k % length;
        /**
         * if the k is multiple of the length of list,it means the list leave unrotated,
         * so return it's head;
         */
        if (steps == 0 ) {
            return head;
        }
        present = head;

        int count = 0;
        /**
         *  find the (length - steps)th node
         */
        while (count++ < length - steps - 1) {
            present = present.next;
        }
        //make the last node pointer to the first
        last.next = head;
        //make the start of the rotate node the be the first node
        head = present.next;
        //make the (length - steps)th node the be the last node
        present.next = null;
        return head;
    }
}
