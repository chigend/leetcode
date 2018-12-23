package n_ary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import model.Node;

public class Solution {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node.children =  Arrays.asList(node2, node3, node4);
        node2.children = Arrays.asList(node5, node6);
        node3.children = new ArrayList<>();
        node4.children = new ArrayList<>();
        node5.children = new ArrayList<>();
        node6.children = new ArrayList<>();
    Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(null);
        System.out.println(result);
    }

    public List<List<Integer>> levelOrder(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            result.add(level);
        }
        return result;
    }
}
