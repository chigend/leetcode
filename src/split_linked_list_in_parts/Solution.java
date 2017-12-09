package split_linked_list_in_parts;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import model.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        node1.next = node2;
        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;
        ListNode[] res = splitListToParts(node1, 5);
        for (ListNode node : res) {
            while (node != null) {
                System.out.print(node.val);
                System.out.print("->");
                node = node.next;
            }
            System.out.println();

        }
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        int count = countNodes(root);
        ListNode[] res = new ListNode[k];
        int index = 0;
        ListNode next = root;
        while (count != 0) {
            int part = count / k;
            if (count % k != 0) {
                part++;
            }
            res[index++] = next;
            count -= part;
            k--;
            while (--part > 0) {
                next = next.next;
            }
            ListNode temp = next;
            next = next.next;
            temp.next = null;
        }
        return res;


    }

    private static int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
