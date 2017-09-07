package decode_string;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "100[leetcode]ef";
        s = decodeString(s);
        System.out.println(s);
    }

    public static String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!Character.isDigit(stack.peek().charAt(0))) {
                    sb.insert(0, stack.pop());
                }
                stack.push(generateString(Integer.parseInt(stack.pop()), sb.toString()));
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(chs[i])) {
                    num = num * 10 + (chs[i] - '0');
                    i++;
                }
                stack.push(num+"");
            } else {
                stack.push(c + "");
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.remove(0));
        }
        return result.toString();
    }

    private static String generateString(int times, String template) {
        if (times == 1) {
            return template;
        }
        if ((times & 1) == 0) {
            return generateString(times / 2, template + template);
        }else {
            return generateString((times - 1)/2, template + template) + template;
        }
    }
}
