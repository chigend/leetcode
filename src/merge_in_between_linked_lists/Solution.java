package merge_in_between_linked_lists;

import model.ListNode;
import tool.ListNodePrinter;
import tool.ListNodeTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        ListNode list1 = ListNodeTestCaseTransformer.transform("[0,1,2,3,4,5,6]");
        ListNode list2 = ListNodeTestCaseTransformer.transform("[1000000,1000001,1000002,1000003,1000004]");
        ListNode merged = mergeInBetween(list1, 2, 5, list2);
        ListNodePrinter.print(merged);

    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2Tail = null;
        ListNode list2Head = list2;
        ListNode list1Head = list1;
        while (list2.next != null) {
            list2Tail = list2.next;
            list2 = list2.next;
        }

        int i = 0;
        ListNode nodeBeforeA = null;
        while (i < a) {
            nodeBeforeA = list1;
            list1 = list1.next;
            i++;
        }
        ListNode nodeAfterB = null;
        while (i <= b) {
            nodeAfterB = list1.next;
            list1 = list1.next;
            i++;
        }

        nodeBeforeA.next = list2Head;
        list2Tail.next = nodeAfterB;
        return list1Head;
    }
}
