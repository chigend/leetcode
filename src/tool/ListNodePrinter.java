package tool;

import model.ListNode;

public class ListNodePrinter {
    public static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head !=null) {
            sb.append(head.val).append("->");
            head = head.next;
        }
        sb.append("null");
        System.out.println(sb);
    }
}
