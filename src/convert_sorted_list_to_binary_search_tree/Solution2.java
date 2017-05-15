package convert_sorted_list_to_binary_search_tree;

import model.ListNode;
import model.TreeNode;

/**
 * @author yejinbiao
 * @create 2017-05-15-15:20
 */

public class Solution2 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        TreeNode root = sortedListToBST(node1);
        traversal(root);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        if (head.next == null)
            return new TreeNode(head.val);
        ListNode beforeMiddle = null;
        //通过快慢指针来寻找中间的节点，同时记录中间节点的前一个节点
        while (fast != null && fast.next != null) {
            beforeMiddle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //记录中间节点的前一个节点的作用就是截断list
        beforeMiddle.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    private static void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        System.out.print(root.val);
        traversal(root.right);
    }
}
