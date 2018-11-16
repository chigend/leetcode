package linked_list_components;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(7);
        ListNode node9 = new ListNode(8);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(10);
        ListNode node12 = new ListNode(11);
        ListNode node13 = new ListNode(12);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = node10;
//        node10.next = node11;
//        node11.next = node12;
//        node12.next = node13;
        Solution solution = new Solution();
        int connectedNum = solution.numComponents(node1, new int[]{0,3,1,4});
        System.out.println(connectedNum);

    }

    public int numComponents(ListNode head, int[] G) {
        boolean[] subSet = new boolean[10001];
        for (int i : G) {
            subSet[i] = true;
        }
        int connectCount = 0;
        boolean preExist = false;
        while (head != null) {
            boolean curExist = subSet[head.val];
            if (!preExist && curExist) {
                connectCount++;
            }
            preExist = curExist;
            head = head.next;
        }
        return connectCount;
    }
}
