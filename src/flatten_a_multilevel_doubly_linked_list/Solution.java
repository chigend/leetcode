package flatten_a_multilevel_doubly_linked_list;

import jdk.nashorn.internal.ir.annotations.Ignore;
import model.Node;

public class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        node1.next = node2; node2.prev = node1;
        node2.next = node3; node3.prev = node2;
        node3.next = node4; node4.prev = node3;
        node3.child = node7;
        node4.next = node5; node5.prev = node4;
        node5.next = node6; node6.prev = node5;
        node7.next = node8; node8.prev = node7;
        node8.next = node9; node9.prev = node8;
        node9.next = node10; node10.prev = node9;
        node11.next = node12; node12.prev = node11;
        node6.child = node11;
        Solution solution = new Solution();
        Node head = solution.flatten(null);
//        Node head = nodes[0];
//        Node tail = nodes[1];
        while (head != null) {
            System.out.print(head.val+"->");
            if (head.child != null) {
                System.out.println("has child");
            }
            head = head.next;
        }
//        System.out.println();
//        while (tail != null) {
//            System.out.print(tail.val+"->");
//            if (tail.child != null) {
//                System.out.println("has child");
//            }
//            tail = tail.prev;
//        }
    }
    public Node flatten(Node head) {
        return  flatten0(head)[0];
    }

    private Node[] flatten0(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            if (node.child != null) {
                Node[] flattenChild = flatten0(node.child);
                flattenChild[1].next = node.next;
                if (node.next != null) {
                    node.next.prev = flattenChild[1];
                }
                node.next = flattenChild[0];
                flattenChild[0].prev = node;
                node.child = null;
            }
            if (node.next == null) {
                tail = node;
            }
            node = node.next;

        }
        return new Node[]{head, tail};
    }
}
