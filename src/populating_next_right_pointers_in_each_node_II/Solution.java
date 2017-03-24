package populating_next_right_pointers_in_each_node_II;

/**
 *
 */

public class Solution {
    private static TreeLinkNode current;

    public static void main(String[] args) {
        TreeLinkNode node = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(7);
        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        connect(node);
        System.out.print(node);
    }

    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        /***
         * base on level order traversal
         * root, the head of next level
         */
        while (root != null) {
            /**
             * current, the current node of current level
             */
            current = root;
            /**
             * first find the previous node
             */
            TreeLinkNode previous = findNextNonNullNode();
            /**
             * if it does not exist,it means the next level is all null node,so break
             */
            if (previous == null) break;
            /**
             * and the first node should be the head of next level
             */
            root = previous;
            while (current != null && previous != null) {
                TreeLinkNode next = null;
                /**
                 * if it satisfy the below condition,it means the current node have two
                 * children,just link the right child to left child
                 */
                if (previous == current.left && current.right != null) {
                    next = current.right;
                } else {
                    /**
                     * else  just find the next non-null node
                     */
                    current = current.next;
                    next = findNextNonNullNode();
                }
                /**
                 * link the  next to previous
                 */
                previous.next = next;
                previous = previous.next;
            }
        }
    }

    private static TreeLinkNode findNextNonNullNode() {
        while (current != null) {
            if (current.left != null) {
                return current.left;
            }
            if (current.right != null) {
                return current.right;
            }
            current = current.next;
        }
        return null;
    }
}
