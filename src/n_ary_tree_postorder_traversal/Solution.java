package n_ary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;

import model.Node;

public class Solution {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        traversal(root, result);
        return result;
    }
    private void traversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            traversal(node, result);
        }
        result.add(root.val);
    }
}
