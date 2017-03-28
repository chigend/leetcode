package remove_k_digits;

import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-28-上午11:13
 */

public class Solution {
    public static void main(String[] args) {
        String s = removeKdigits("1432219", 3);
        System.out.println(s);
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        char[] chars = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        int end = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
            if (k == 0) {
                end = i;
                break;
            }
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.remove(0));
        }
        while (end != -1 && ++end < chars.length) {
            sb.append(chars[end]);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
