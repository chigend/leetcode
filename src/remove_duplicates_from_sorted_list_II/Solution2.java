package remove_duplicates_from_sorted_list_II;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-07-下午3:38
 */

public class Solution2 {
    public static void main(String[] args) {


    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        /**
         * a pointer which track the node before duplicate value nodes
         */
        ListNode slow = fakeHead;
        /**
         * the current node
         */
        ListNode fast = head;
        while (fast != null) {
            /**
             * find the last duplicate node
             */
            while (fast.next != null && fast.val == fast.next.val) {

                fast = fast.next;
            }
            /**
             * if slow.next != fast,it means there duplicate value nodes
             */
            if (slow.next != fast) {
                //remove it
                slow.next = fast.next;
            }else {
                /**
                 * it slow.next = fast, it means there are duplicate value nodes,
                 * move down the pointer of slow
                 */
                slow = slow.next;
            }

            fast = fast.next;
        }
        return fakeHead.next;
    }
}
