package two_sum_II_input_array_is_sorted;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-12-上午10:02
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,24,50,79,88,150,345};
//        int[] nums = {2,3,4};
//        int [] nums = {1,2,3,4,4,9,56,90};
        int[] indices = twoSum(nums, 200);
        System.out.println(Arrays.toString(indices));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int target0 = target - numbers[i];
            int index2 = binarySearch(numbers, i + 1 , target0);
            if (index2 < 0) {
                continue;
            }else {
                result[0] = i + 1;
                result[1] = index2 + 1;
                return result;
            }
        }
        return result;
    }

    private static int binarySearch(int[] numbers, int start, int target) {
        int low = start;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (low + high) >>>1;
            int midValue = numbers[mid];
            if (midValue == target) {
                return mid;
            }else if (midValue > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -(low + 1);

    }
}
