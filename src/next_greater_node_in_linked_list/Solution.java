package next_greater_node_in_linked_list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import model.ListNode;
import tool.ListNodeTestCaseTransformer;

public class Solution {
    public static void main(String[] args) {
        ListNode transform = ListNodeTestCaseTransformer.transform("[1,7,5,1,9,2,5,1]");
        int[] ints = nextLargerNodes(transform);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] nextLargerNodes(ListNode head) {
        ListNode node = head;

        List<Integer> values = new ArrayList<>();
        while (node != null) {
            values.add(node.val);
            node = node.next;
        }
        int[] res = new int[values.size()];

        Stack<Integer> stack = new Stack<>();

        int fast = 0;
        while (fast < values.size()) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(fast)) {
                res[stack.pop()] = values.get(fast);
            }
            stack.push(fast);
            fast++;
        }
        return res;
    }
}
