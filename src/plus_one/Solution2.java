package plus_one;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-17-下午1:34
 */

public class Solution2 {
    public static void main(String[] args) {
        int [] num = plusOne(new int[] {9});
        System.out
                .print(Arrays.toString(num));
    }

    public static int[] plusOne(int [] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;

                return digits;
            }
            digits[i] = 0;
        }
        /**
         * when the array is not all 9's it will return ahead,and won't do the code below
         *
         * and when the array is all 9's ,just set result[0] = 1 since the value 9 in original array will all be 0 as plus one
         *
         */
        int [] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
