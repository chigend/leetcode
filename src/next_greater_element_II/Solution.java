package next_greater_element_II;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-15-上午9:43
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums = new int[] {1};
        int [] nextGreaters = nextGreaterElements(nums);
        System.out.println(Arrays.toString(nextGreaters));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int [] nextGreaters = new int[len];
        out:for (int i = 0; i < len; i ++) {
            int num = nums[i];
            /**
             * first search the right hand of current num
             */
            for (int j = i + 1; j < len; j++) {
                int next = nums[j];
                if (next > num) {
                    nextGreaters[i] = next;
                    continue out;
                }
            }
            /**
             * if not found on the right hand of the current value,just search for the next greater
             * num in left hand
             */
            for (int j = 0; j < i; j++) {
                int next = nums[j];
                if (next > num) {
                    nextGreaters[i] = next;
                    continue out;
                }
            }
            nextGreaters[i] = -1;
        }
        return nextGreaters;
    }

    /**
     * since the array is circular,just search for 2 * nums.length
     * @param nums
     * @return
     */
    public static int[] nextGreaterElements2(int[] nums) {
        int len = nums.length;
        int [] nextGreaters = new int[len];
        Arrays.fill(nextGreaters, -1);
        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < 2 * len; i++) {
            int num = nums[i % len];
            while (!indices.isEmpty() && nums[indices.peek()] < num) {
                nextGreaters[indices.pop()] =  num;
            }
            if (i < len) {
                /**
                 * push every index into stack,since the indices are duplicate from len to 2 * len
                 * so just push index that < len
                 */
                indices.push(i);
            }
        }
        return nextGreaters;
    }
}
