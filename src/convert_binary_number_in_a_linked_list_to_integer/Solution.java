package convert_binary_number_in_a_linked_list_to_integer;

import model.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(0);
        ListNode l13 = new ListNode(1);
        ListNode l14 = new ListNode(1);
        ListNode l15 = new ListNode(15);
        ListNode l16 = new ListNode(16);
        ListNode l17 = new ListNode(20);

        l11.next = l12;
        l12.next = l13;
        //        l13.next = l14;
        //        l14.next = l15;
        //        l15.next = l16;
        //        l16.next = l17;
        int decimalValue = getDecimalValue(l11);
        System.out.println(decimalValue);

    }

    public static int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = res * 2 + head.val;
            head = head.next;
        }
        return res;
    }
}
