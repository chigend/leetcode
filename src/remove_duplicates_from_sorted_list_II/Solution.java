package remove_duplicates_from_sorted_list_II;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-07-下午12:40
 */

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(4);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;
        ListNode head = deleteDuplicates(l1);
        while (head != null) {
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        /**
         * the pointer which track the node before duplicate
         */
        ListNode nodeBeforeDuplicate = fakeHead;
        /**
         * a flag indicate if there are duplicate value node
         */
        boolean duplicate = false;
        /**
         * a flag indicate if there are duplicate nodes unremoved
         */
        boolean duplicateUnremoved = false;
        Integer presentValue = null;
        /**
         * a pointer which track the last unduplicate node
         */
        ListNode lastUnDuplicateNode = fakeHead;
        /**
         * the pointer which track the previous node as present move down
         */
        ListNode previous = fakeHead;
        ListNode present = head;
        while (present != null) {
            if (presentValue == null || present.val != presentValue) {
                /**
                 * the value to be compared later
                 */
                presentValue = present.val;
                if (!duplicate) {
                    lastUnDuplicateNode = previous;
                    /**
                     * if the flag is true,mean there are duplicate value nodes unremoved,
                     * so remove it, make the nodeBeforeDuplicate's next point to previous
                     * node,because the current node can not be ensured undeplicate.
                     * and set the flag to false;
                     */
                    if (duplicateUnremoved) {
                        nodeBeforeDuplicate.next = lastUnDuplicateNode;
                        duplicateUnremoved = false;
                    }
                    /**
                     * if the node before the current node is not a duplicate value node ,
                     * move down the pointer
                     */
                    nodeBeforeDuplicate = lastUnDuplicateNode;
                }
                duplicate = false;
            } else {
                /**
                 * if the same value come more than twice,mark the two flags to true;
                 */
                duplicate = true;
                duplicateUnremoved = true;
            }
            /**
             * move down the pointer
             */
            previous = present;
            present = present.next;
        }
        /**
         * if the linkedlist end with duplicate value nodes,we should make the nodeBeforeDuplicate point
         * to null;
         */
        if (duplicate && previous.val == presentValue) {
            nodeBeforeDuplicate.next = null;
            duplicateUnremoved = false;
        }
        /**
         * in case the last node leave unsolved  e.g (1->2->2->3->3->4)
         */
        if (duplicateUnremoved) {
            nodeBeforeDuplicate.next = previous;
        }
        return fakeHead.next;
    }
}
