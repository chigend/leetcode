package remove_all_adjacent_duplicates_in_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        String abbaca = removeDuplicates("aabba");
        System.out.println(abbaca);
    }

    public static String removeDuplicates(String s) {
        char[] chs = s.toCharArray();
        LinkedList<Character> queue = new LinkedList<>();
        for (int i = 0; i < chs.length; i++) {
            char cur = chs[i];
            if (queue.isEmpty() || queue.peekLast() != cur) {
                queue.offerLast(cur);
            }else if (queue.peekLast() == cur) {
                queue.removeLast();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.removeFirst());
        }
        return sb.toString();
    }
}
