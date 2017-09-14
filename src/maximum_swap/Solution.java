package maximum_swap;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int swap = maximumSwap(115);
        System.out.println(swap);
    }

    public static int maximumSwap(int num) {
        int number = num;
        int len = String.valueOf(num).length();
        int[] digits = new int[len];
        while (num != 0) {
            digits[--len] = num % 10;
            num /= 10;
        }
        int maxIndex = -1;//the index where the digit appear to be smaller than digits[index+1]
        for (int i = 0; i < digits.length - 1; i++) {
            //ignore the reverse order part
            if (digits[i] < digits[i + 1]) {
                maxIndex = i;
                while (++i < digits.length) {
                    if (digits[i] >= digits[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }
        }
        //the digits in original num is reverse sorted
        if (maxIndex == -1) {
            return number;
        }
        //swap iterate from start incase number like 115
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] < digits[maxIndex]) {
                int temp = digits[maxIndex];
                digits[maxIndex] = digits[i];
                digits[i] = temp;
                break;
            }
        }
        int result = 0;
        for (int n : digits) result = result * 10 + n;
        return result;
    }
}
