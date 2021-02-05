package shuffle_the_array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{1, 2, 3, 4, 5, 6, 7, 8,9,10,11,12}, 6)));
    }

    public static int[] shuffle(int[] nums, int n) {

        for (int i = n; i < 2 * n; i++) {
            nums[i] = (nums[i] << 10) | nums[i - n];
        }

        for (int i = 0, j = 0; j < n; i += 2, j++) {
            nums[i] = nums[j + n] & 1023;
            nums[i + 1] = (nums[j + n] >> 10);
        }
        return nums;
    }
}
