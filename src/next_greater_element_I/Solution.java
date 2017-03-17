package next_greater_element_I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author yejinbiao
 * @create 2017-03-10-下午1:54
 */

public class Solution {
    public static void main(String[] args) {
        int [] nums1 = new int[]{};
        int [] nums2 = new int[]{};
        int [] nexts = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(nexts));
    }

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        int [] nexts = new int[findNums.length] ;
        for (int i = 0;i < findNums.length;i ++) {
            int nextGreater = -1;
            int num = findNums[i];
            int start = 0;
            for (int j = 0; j < nums.length;j ++) {
                if (nums[j] == num) {
                    start = j;
                    break;
                }
            }

            for (int j = start + 1;j < nums.length;j ++) {
                if (nums[j] > num) {
                    nextGreater = nums[j];
                    break;
                }
            }
            nexts[i] = nextGreater;
        }
        return nexts;
    }

    public static int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> table = new HashMap<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                table.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0;i < findNums.length; i ++) {
            findNums[i] = table.getOrDefault(findNums[i], -1);
        }
        return findNums;
    }
}
