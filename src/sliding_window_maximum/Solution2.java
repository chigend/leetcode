package sliding_window_maximum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,0,5};
        nums = maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public  static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];
        //queue store index
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - k + 1 > queue.peek()) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }
        return res;
    }
}
