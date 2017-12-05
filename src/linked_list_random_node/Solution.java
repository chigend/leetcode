package linked_list_random_node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-03-06-下午5:42
 */

public class Solution {
    private List<Integer> values = new ArrayList<>();
    private Random random;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        random = new Random();
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int randomNumber = random.nextInt(values.size());
        return values.get(randomNumber);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int count = 0; count < 100000; count++) {
            int value = random.nextInt(10);
            array[value]++;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ":" + array[i]);
        }

    }
}
