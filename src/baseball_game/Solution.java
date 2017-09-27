package baseball_game;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            if ("C".equals(op)) {
                sum -= stack.pop();
            } else if ("+".equals(op)) {
                int point = stack.get(stack.size() - 2) + stack.peek();
                sum += point;
                stack.push(point);
            } else if ("D".equals(op)) {
                int point = stack.peek() * 2;
                sum += point;
                stack.push(point);
            } else {
                int point = Integer.parseInt(op);
                sum += point;
                stack.push(point);
            }
        }
        return sum;
    }
}
