package intersection_of_two_linked_lists;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-08-上午10:20
 */

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * if the head is the same ,so the head is the intersection node
         */
        if (headA == headB) {
            return headA;
        }
        if (headA == null || headB == null) {
            return null;
        }
        ListNode lastA = null;
        ListNode lastB = null;
        ListNode presentA = headA;
        ListNode presentB = headB;
        int lengthA = 0;
        int lengthB = 0;
        while (presentA != null) {
            //get the length of list A
            lengthA++;
            //get the last node of list A
            lastA = presentA;
            presentA = presentA.next;
        }

        while (presentB != null) {
            //get the length of list B
            lengthB++;
            //get the last node of list B
            lastB = presentB;
            presentB = presentB.next;
        }
        /**
         * if there exist a node that is the intersection of two lists ,the last node will be the same
         */
        if (lastA != lastB) {
            return null;
        }
        presentA = headA;
        presentB = headB;
        //get the node numbers that should be skipped
        int skipNode = Math.abs(lengthA - lengthB);
        if (lengthA > lengthB) {
            int count = 0;
            while (count++ < skipNode) {
                presentA = presentA.next;
            }
        }
        if (lengthB > lengthA) {
            int count = 0;
            while (count++ < skipNode) {
                presentB = presentB.next;
            }
        }
        /**
         * because the longer list skip some nodes extra ，now
         * the two list is the same long,so just compare every
         * node along and find out the intersection node
         */
        while (presentA != null) {
            if (presentA == presentB) {
                return presentA;
            }
            presentA = presentA.next;
            presentB = presentB.next;
        }
        return null;
    }
}
