package plus_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-17-下午1:25
 */

public class Solution {
    public static void main(String[] args) {
        int [] numbers = {0};
        numbers = plusOne(numbers);
        System.out.print(Arrays.toString(numbers));
    }

    public static int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            result.add(0, sum);
        }
        if (carry == 1) {
            result.add(0,1);

        }
        int [] numbers = new int[result.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = result.get(i);
        }
        return numbers;
    }
}
