package n_ary_tree_preorder_traversal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Node;

/**
 * recursive solution, it's easy
 */

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
        Solution solution = new Solution();
        List<Integer> result = solution.preorder(node);
        System.out.println(result);

    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }

    private void traversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node node : root.children) {
            traversal(node, result);
        }
    }
}
