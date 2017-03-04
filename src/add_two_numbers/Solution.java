package add_two_numbers;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-04-上午9:40
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(0);
        ListNode l12 = new ListNode(8);
        ListNode l13 = new ListNode(6);
        ListNode l14 = new ListNode(5);
        ListNode l15 = new ListNode(6);
        ListNode l16 = new ListNode(8);
        ListNode l17 = new ListNode(3);
        ListNode l18 = new ListNode(5);
        ListNode l19 = new ListNode(7);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(7);
        ListNode l24 = new ListNode(8);
        ListNode l25 = new ListNode(0);
        ListNode l26 = new ListNode(8);
        ListNode l27 = new ListNode(5);
        ListNode l28 = new ListNode(8);
        ListNode l29 = new ListNode(9);
        ListNode l30 = new ListNode(7);
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;
        l17.next = l18;
        l18.next = l19;
        l22.next = l23;
        l23.next = l24;
        l24.next = l25;
        l25.next = l26;
        l26.next = l27;
        l27.next = l28;
        l28.next = l29;
        l29.next = l30;
        ListNode node =  addTwoNumbers(l11,l22);
        while (node != null) {
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }

    }

    public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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
