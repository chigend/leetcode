package delete_n_nodes_after_m_nodes_of_a_linked_list;

import model.ListNode;
import tool.ListNodePrinter;
import tool.ListNodeTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        ListNode transform = ListNodeTestCaseTransformer.transform("[9,3,7,7,9,10,8,2]");
        ListNode node = deleteNodes(transform,3,2);
        ListNodePrinter.print(node);
    }

    public static ListNode deleteNodes(ListNode head, int m, int n) {
        int keep = m;
        int delete = n;

        ListNode fake = new ListNode(-1);
        fake.next = head;

        ListNode last = fake;
        while (head != null) {
            if (keep > 0) {
                last = head;
                keep--;
            } else if (delete > 0) {
                delete--;
            } else if (delete == 0) {
                last.next = head;
                last = head;
                keep = m - 1;
                delete = n;
            }
            head = head.next;
        }
        //避免最后几个是要删除的没走到 else if delete==0的逻辑就退出了
        last.next = null;
        return fake.next;
    }

}
