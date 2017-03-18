package valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-18-下午12:08
 */

public class Solution {
    public static void main(String[] args) {
        String s = "()]{}";
        boolean isValid = isValid(s);
        System.out.print(isValid);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char [] chars = s.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                stack.push(c);
            }else {
                if (stack.isEmpty() ||map.get(stack.pop()) != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
