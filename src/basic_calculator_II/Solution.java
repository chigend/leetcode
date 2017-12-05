package basic_calculator_II;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        int res = calculate("3 + 2 / 2 - 6 - 24 / 2 *4/ 2 - 3");
        System.out.println(res);
    }

    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (Character.isDigit(chs[i])) {
                int num = getNextNum(i, chs);
                operands.offer(num);
                i += String.valueOf(num).length() - 1;
            } else {
                char operator = chs[i];
                if (operator == '*' || operator == '/') {
                    int num = getNextNum(i + 1, chs);
                    i += String.valueOf(num).length();
                    operands.offer(calc(operands.pollLast(), num, operator));
                } else {
                    operators.offer(operator);
                }
            }
        }

        int res = operands.poll();
        while (!operators.isEmpty()) {
            int num2 = operands.poll();
            res = calc(res, num2, operators.poll());
        }
        return res;
    }

    private static int getNextNum(int start, char[] chs) {
        int res = 0;
        for (int i = start; i < chs.length; i++) {
            if (Character.isDigit(chs[i])) {
                res = res * 10 + (chs[i] - '0');
            } else {
                break;
            }
        }
        return res;
    }

    public static int calc(int num1, int num2, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
            default:
                break;
        }
        return result;
    }
}
