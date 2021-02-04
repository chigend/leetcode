package maximum_depth_of_n_ary_tree;

import model.Node;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maxChildDepth = 0;

        for (Node child : root.children) {
            maxChildDepth = Math.max(maxChildDepth, maxDepth(child));
        }
        return 1 + maxChildDepth;
    }
}
