package copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node.next = node2;
        node2.next = node3;
        node.random = node3;
        node2.random = node;
        node3.random = node2;
        node = copyRandomList(node);
        int count = 0;
        while (count++ < 20) {
            System.out.print(node.label+"->");
            node = node.random;
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode fake = new RandomListNode(-1);
        RandomListNode pre = fake;
        RandomListNode next = head;
        while (next != null) {
            RandomListNode node = new RandomListNode(next.label);
            pre.next = node;
            map.put(next, node);
            pre = pre.next;
            next = next.next;
        }
        next = head;
        pre = fake;
        while (next != null) {
            pre.next.random = map.get(next.random);
            pre = pre.next;
            next = next.next;
        }
        return fake.next;
    }
}
