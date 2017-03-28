package evaluate_reverse_polish_notation;

import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-28-上午10:43
 */

public class Solution {
    public static void main(String[] args) {
        String [] strs = {"4", "13", "5", "/", "+"};
        int result = evalRPN(strs);
        System.out.print(result);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "/":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                case "-":
                    int substrahend = stack.pop();
                    int minuend = stack.pop();
                    stack.push(minuend - substrahend);
                    break;
                default:stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
