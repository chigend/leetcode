package merge_k_sorted_list;

import model.ListNode;

/**
 * @author yejinbiao
 * @create 2017-06-23-10:07
 */

public class Solution {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return mergeKLists(lists,0,lists.length-1);
    }
    private ListNode mergeKLists(ListNode[] lists,int start,int end){
        if (end == start) return lists[start];
        ListNode left = lists[start];
        ListNode right = lists[end];
        if (end - start > 1) {
            int mid = (start+end) >>1;
            left = mergeKLists(lists,start,mid);
            right = mergeKLists(lists,mid+1,end);
        }
        return mergeTwoLists(left,right);

    }
    public  ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        ListNode node;
        if (n1.val < n2.val) {
            node = n1;
            node.next = mergeTwoLists(n1.next, n2);
        } else {
            node = n2;
            node.next = mergeTwoLists(n1, n2.next);
        }
        return node;
    }
}
