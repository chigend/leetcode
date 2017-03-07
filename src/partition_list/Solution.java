package partition_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-07-上午10:32
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2= new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
        ListNode head = partition(l1, 2);

        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
    }

    /**
     *  define two pointers,one pointer indicate the latest node which the value is less than x,
     *  and a pointer indicate the latest node which the value is larger than x, when a node's value
     *  is less than x and the large pointer indicate a not-null node, it means some larger value nodes
     *  split the less value nodes,so change the position of the present less value node.(insert after the lastest  less value)
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(Integer.MIN_VALUE);
        small.next = head;
        ListNode large = null;
        ListNode present = head;
        while (present != null) {
            if (present.val < x) {
                if (large != null) {
                    large.next = present.next;
                    present.next = small.next;
                    if (small.next == head) {   //in case the larger value node is the head,after position changed, some other node become the head,
                        head = present;    // so we should track the head when some node insert before the head; e.g  (2->1, the head will be 1 )
                    }
                    small.next = present;
                }
                small = present;
            }else {
                large = present;
            }
            present = present.next;
        }
        return head;
    }


}
