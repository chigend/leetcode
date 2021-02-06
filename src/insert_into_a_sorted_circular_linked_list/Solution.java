package insert_into_a_sorted_circular_linked_list;

import model.ListNode;
import model.Node;
import tool.NodePrinter;
import tool.NodeTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        test("[3,4,1]", 2);
        test("[3,4,1]", 0);
        test("[3,4,1]", 4);
        test("[1]", 0);
        test("[1]", 2);
        test("[3,3,3]", 3);
        test("[3,5,1]", 0);
    }

    public static void test(String testcase, int insert) {
        Node node = NodeTestCaseTransformer.transform(testcase);

        node = insert(node, insert);

        NodePrinter.print(node);
    }

    public static Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }


        Node fake = new Node(Integer.MAX_VALUE);
        fake.next = head;
        Node last = head;
        head = head.next;
        while (true) {
            if (head.val >= insertVal && last.val <= insertVal
                    || ((insertVal >= last.val || insertVal <= head.val) && last.val > head.val
                    || head == fake.next)) {
                Node node = new Node(insertVal);
                last.next = node;
                node.next = head;
                break;
            }
            last = head;
            head = head.next;
        }
        return fake.next;
    }
}
