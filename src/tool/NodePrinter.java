package tool;

import model.ListNode;
import model.Node;

public class NodePrinter {
    public static void print(Node insert) {
        Node head = insert;
        StringBuilder sb = new StringBuilder();
        while (insert != head.next) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append(head.val);
        System.out.println(sb);
    }
}
