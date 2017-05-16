package sort_colors;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-05-16-10:48
 */

public class Solution {
    public static void main(String[] args) {
        int[] num = {0, 2, 1};
        sortColors(num);
        System.out.print(Arrays.toString(num));
    }

    public static void sortColors(int[] nums) {
        int pointer0 = 0;//a pointer indicate the position that next 0 will fill in;
        int pointer1 = 0;// a pointer indicate the position that next 1 will fill in
        int end = nums.length;
        for (int i = 0; i < end; i++) {
            if (nums[i] == 1) {
                //since 1 should appear after 0,once we meet 1 and the pointer1 before pointer0,
                //we should reset the pointer1 to pointer0
                if (pointer1 < pointer0) pointer1 = pointer0;
                nums[pointer1++] = 1;
            } else if (nums[i] == 0) {
                //if pointer0 < pointer1 ,it means the current position where pointer0 indicate is filled with
                //1, so we should move 1 to the next position
                if (pointer0 < pointer1) nums[pointer1++] = 1;
                nums[pointer0++] = 0;
            }else {
                nums[i] = nums[--end];
                nums[end] = 2;
                i--;
            }
        }

    }
}
