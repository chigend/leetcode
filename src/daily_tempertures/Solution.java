package daily_tempertures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] res = dailyTemperatures(new int[]{1,3,2});
        System.out.println(Arrays.toString(res));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures.length == 0) {
            return temperatures;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] result = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
