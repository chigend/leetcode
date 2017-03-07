package linked_list_random_node;

import model.ListNode;

import java.util.Random;

/**
 * @author yejinbiao
 * @create 2017-03-06-下午5:52
 */

public class Solution2 {
    private ListNode head;
    Random r = new Random();
    int present;
    int size = 0;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution2(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode temp = head;
        while (temp != null) {
            size++;
            double p = (double) 1 / size;
            double random = r.nextDouble();
            if (random < p) {
                present = temp.val;
            }
            temp = temp.next;
        }
        size = 0;
        return present;
    }


}
