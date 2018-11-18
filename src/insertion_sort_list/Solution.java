package insertion_sort_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-07-04-10:04
 */

public class Solution {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        //        node2.next = node;
        node.next = node1;
        node1.next = node2;
        Solution solution = new Solution();

        ListNode result = solution.insertionSortList2(node);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public ListNode insertionSortList2(ListNode head) {
        ListNode fake = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            ListNode node = fake;
            while (node.next != null && node.next.val <= head.val) {
                node = node.next;
            }
            head.next = node.next;
            node.next = head;
            head = next;
        }
        return fake.next;
    }
}
