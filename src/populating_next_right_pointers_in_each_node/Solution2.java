package populating_next_right_pointers_in_each_node;

/**
 * @author yejinbiao
 * @create 2017-03-24-上午9:55
 */

public class Solution2 {
    public static void main(String[] args) {

        TreeLinkNode node = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);
        TreeLinkNode node10 = new TreeLinkNode(10);
        TreeLinkNode node11 = new TreeLinkNode(11);
        TreeLinkNode node12 = new TreeLinkNode(12);
        TreeLinkNode node13 = new TreeLinkNode(13);
        TreeLinkNode node14 = new TreeLinkNode(14);
        TreeLinkNode node15 = new TreeLinkNode(15);

        node.left = node2;
        node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;
        connect(node);
        System.out.print(node);
    }
    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        while (root.left != null) {
            TreeLinkNode node = root;
            /**
             * iterate every level
             */
            while (node != null) {
                node.left.next = node.right;
                if (node.next != null) node.right.next = node.next.left;
                node = node.next;
            }
            root = root.left;
        }
    }
}
