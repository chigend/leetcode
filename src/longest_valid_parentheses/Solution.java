package longest_valid_parentheses;

import java.util.IntSummaryStatistics;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2016/11/23
 */
public class Solution {
    public static void main(String[] args) {
        int length = longestValidParentheses("()()()()))");
        System.out.print(length);
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        //dp[i]表示截取到第i个字符，其所包含的合法的最大长度
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length()];
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //把左括号的坐标压入栈
                stack.push(i);
            } else {
                //当遇到右括号并且没有匹配的左括号时，记录起始点为当前点，因为前面的已经不匹配
                if (stack.size() == 0) {

                    start = i;
                } else {
                    stack.pop();//如果栈中有左括号先出栈
                    if (stack.size() == 0) { //判断栈中还有没有左括号

                        max = Math.max(max, i - start);//如果没有,长度为当前点到起始点距离
                    } else {
                        //如果有，说明栈中还有未匹配的左括号，那么最长的长度只能当前匹配的两个括号之间的距离
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}
