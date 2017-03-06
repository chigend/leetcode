package add_two_numbers_II;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-06-下午1:23
 */

/**
 * example: (7->2->4->7) + (5->6->4) = (7->8->0->7)
 *
 * first, reverse the two input listnode ,then add the two number  倒转后可以用Add_Two_Numbers 来解决
 * last ,reverse the result link
 */
public class Solution {
    public static void main(String [] args) {
        ListNode l11 = new ListNode(7);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        ListNode l14 = new ListNode(3);
        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l21.next = l22;
        l22.next = l23;
        ListNode sum = addTwoNumber(l11, l21);
        while (sum != null) {
            System.out.print(sum.val + "->");
            sum = sum.next;
        }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
       return reverseList(addTwoNumber(l1, l2));
    }

    private static  ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode present = null;
        ListNode next = head;
        while (next != null) {
            present = next;
            next = next.next;
            present.next = previous;
            previous = present;
        }
        return present;
    }
    private static ListNode addTwoNumber(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (true) {
            int sum = 0;
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1 == null && l2 != null) {
                sum = l2.val + carry;
                l2 = l2.next;
            }else if (l2 == null && l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            }else if (carry == 1){
                sum = carry;
            }else {
                return head.next;
            }
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            temp.next = new ListNode(sum);
            temp = temp.next;

        }
    }
}
