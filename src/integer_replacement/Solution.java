package integer_replacement;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-17-上午9:09
 */

public class Solution {
    private static Map<Integer, Integer> hashtable = new HashMap<>();
    public static void main(String[] args) {
        int steps = integerReplacement(65535);
        System.out.print(steps);
    }

    public static int integerReplacement(int n) {
        return helper(n);
    }
    private static int helper(int n) {
        if (n == 1) {
            return 0;
        }
        Integer steps = hashtable.get(n);
        if (steps == null) {
            if ((n & 1) == 0) {
                steps = 1 + helper(n >>> 1);
                hashtable.put(n, steps);
            }else {
                steps = 1 + Math.min(helper(n + 1), helper(n - 1));
            }
        }
        return steps;
    }
}
