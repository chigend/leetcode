package plus_one_linked_list;

import java.util.LinkedList;

import model.ListNode;
import tool.ListNodePrinter;
import tool.ListNodeTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        ListNode transform = ListNodeTestCaseTransformer.transform("1,2,3]");
        ListNode node = plusOne(transform);
        ListNodePrinter.print(node);
    }

    public static ListNode plusOne(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;

        ListNode not9 = fake;
        while (head != null) {
            if (head.val != 9) {
                not9 = head;
            }
            head = head.next;
        }
        not9.val++;
        not9 = not9.next;
        while (not9 != null) {
            not9.val = 0;
            not9 = not9.next;
        }
        return fake.val == 1 ? fake : fake.next;
    }

}
