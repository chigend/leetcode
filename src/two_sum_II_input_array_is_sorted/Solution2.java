package two_sum_II_input_array_is_sorted;

/**
 * @author yejinbiao
 * @create 2017-03-21-下午3:37
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] numbers, int target) {
        int [] result = new int[2];
        int slow = 0;
        int fast = numbers.length - 1;
        while (slow < fast) {
            int sum = numbers[slow] + numbers[fast];
            if (sum > target) {
                fast--;
            }else if(sum < target) {
                slow++;
            }else {
                result[0] = slow + 1;
                result[1] = fast + 1;
                return result;
            }
        }
        return result;
    }
}
