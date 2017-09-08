package copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
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
        return copyRandomList0(head, map);
    }

    public static RandomListNode copyRandomList0(RandomListNode head, Map<RandomListNode, RandomListNode> map) {
        if (head == null) {
            return head;
        }
        RandomListNode copy = map.get(head);
        if (copy != null) {
            return copy;
        }
        copy = new RandomListNode(head.label);
        map.put(head, copy);
        copy.random = copyRandomList0(head.random, map);
        copy.next = copyRandomList0(head.next, map);
        return copy;
    }
}
