package palindrome_linked_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-08-下午1:52
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(7);
        ListNode l14 = new ListNode(3);
        ListNode l15 = new ListNode(7);
        ListNode l16 = new ListNode(2);
        ListNode l17 = new ListNode(2);


        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        boolean isPalindrome = isPalindrome(l17);
        System.out.println(isPalindrome);
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode previous = null;
        ListNode present = head;
        while (present != null) {
            ListNode node = new ListNode(present.val);
            node.next = previous;
            previous = node;
            present = present.next;
        }
        ListNode tail = previous;
        while (head != null) {
            if (head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

}
