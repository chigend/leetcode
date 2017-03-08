package linked_list_cycle;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-08-上午11:09
 */

public class Solution {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

    }
}
