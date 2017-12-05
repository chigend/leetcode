package second_minimum_node_in_a_binary_tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.TreeNode;

public class Solution {
    public static void main(String[] args) {

    }

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> res = new HashSet<>();
        traversal(res, root);
        List<Integer> list = new ArrayList<>(res);
        return res.size() < 2 ? -1 : list.get(1);
    }
    private void traversal(Set<Integer> res,TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traversal(res, root.left);
        traversal(res, root.right);
    }
}
