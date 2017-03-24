package populating_next_right_pointers_in_each_node_II;

/**
 * @author yejinbiao
 * @create 2017-03-24-下午12:52
 */

public class Solution2 {
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
        //root, the head node of next level
        TreeLinkNode previous = null; //the previous node of next level
        TreeLinkNode current = root;//the current node of current level
        //based on level order traversal
        while (current != null) {
            //iterate on current level
            while (current != null) {
                //left child
                if (current.left != null) {
                    /**
                     * if previous is not null, it means current.left is not the first non-null node in next level,so
                     * link previous node to the current.left node,
                     * if previous is null,it means current.left is the first non-null node,
                     * so get the head of next level
                     */
                    if (previous != null) previous.next = current.left;
                    else root = current.left;
                    //every time the current.left is not null, we move the previous
                    previous = current.left;
                }
                //right child  right part is the same as left part
                if (current.right != null) {
                    if (previous != null) previous.next = current.right;
                    else root = current.right;
                    previous = current.right;
                }
                //move current to it's next
                current = current.next;
            }
            current = root;
            root = null;
            //as we start at a new level,we should set the previous to null,as it should be the head
            previous = null;
        }
    }
}
