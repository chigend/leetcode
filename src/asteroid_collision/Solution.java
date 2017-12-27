package asteroid_collision;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] res = asteroidCollision(new int[]{-2,-1,1,-2,2});
        System.out.println(Arrays.toString(res));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            collision(stack, asteroids[i]);
        }
        int[] res = new int[stack.size()];
        int index = res.length-1;
        while (!stack.isEmpty()){
            res[index--] = stack.pop();
        }
        return res;
    }
    public static void collision(Stack<Integer> stack, int current){
        while (!stack.isEmpty() && stack.peek() > 0 && current < 0) {
            if (-current <= stack.peek()) {
                if (-current == stack.peek()){
                    stack.pop();
                }
                return;
            }else {
                stack.pop();
            }
        }
        stack.push(current);
    }
}
