package remove_k_digits;

import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-28-上午11:13
 */

public class Solution {
    public static void main(String[] args) {
        String s = removeKdigits("1173",2);
        System.out.println(s);
    }

    public static String removeKdigits(String num, int k) {
        if (num.length() == k ) return "0";
        char[] chars = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(chars[0]);
        int end = -1;
        for (int i = 1; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
                continue;
            }
            if (chars[i] >= stack.peek()) stack.push(chars[i]);
            else {
                while (k > 0 && !stack.isEmpty() &&chars[i] < stack.peek()) {
                    stack.pop();
                    k--;
                }
                stack.push(chars[i]);
                if (k == 0) {
                    end = i;
                    break;
                }
            }
            if (i == chars.length - 1) {
                while (k > 0)  {
                    stack.pop();
                    k--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.remove(0));
        }
        while (end != -1 && ++end < chars.length) {
            sb.append(chars[end]);
        }
        while (sb.length() > 0 &&sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
