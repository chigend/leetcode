package sliding_window_maximum;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[]  res = new int[nums.length - k + 1];
        MaxQueue queue = new MaxQueue();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            queue.push(num);
            if (i >= k) {
                queue.pop();
            }
            if (i >= k - 1) {
                res[i - k + 1] = queue.getMax();
            }
        }
        return res;
    }

    static class MaxStack{
        Stack<Integer> maxes = new Stack<>();
        Stack<Integer> stack = new Stack<>();

        public void push(int num) {
            if (maxes.isEmpty() || num >= maxes.peek()) {
                maxes.push(num);
            }
            stack.push(num);
        }

        public int pop() {
            int num = stack.pop();
            if (num == maxes.peek()) {
                maxes.pop();
            }
            return num;
        }

        public int getMax() {
            return maxes.peek();
        }

        public boolean isEmpty(){
            return stack.isEmpty();
        }
    }

    static class MaxQueue{
        MaxStack enque = new MaxStack();
        MaxStack deque = new MaxStack();

        public void push(int num) {
            enque.push(num);
        }

        public int pop() {
            if (deque.isEmpty()) {
                while (!enque.isEmpty()) {
                    deque.push(enque.pop());
                }
            }
            return deque.pop();
        }

        public int getMax(){
            if (enque.isEmpty()) {
                return deque.getMax();
            }
            if (deque.isEmpty()) {
                return enque.getMax();
            }
            return enque.getMax() > deque.getMax() ? enque.getMax() : deque.getMax();
        }
    }
}
