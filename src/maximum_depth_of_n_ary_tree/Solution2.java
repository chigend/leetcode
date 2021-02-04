package maximum_depth_of_n_ary_tree;

import java.util.LinkedList;
import java.util.Queue;

import model.Node;

public class Solution2 {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth += 1;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
        }

        return depth;
    }

}
