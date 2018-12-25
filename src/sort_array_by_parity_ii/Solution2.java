package sort_array_by_parity_ii;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
            Solution solution = new Solution();
            int[] res = solution.sortArrayByParityII(new int[]{4,2,5,7});
            System.out.println(Arrays.toString(res));
    }

    public int[] sortArrayByParityII(int[] A) {
        int odd = 0;
        int even = 1;
        while (odd < A.length && even < A.length) {
            while (odd < A.length && (odd & 1) == 0) {
                odd += 2;
            }
            while (even < A.length && (even & 1) == 1) {
                even += 2;
            }
            if (odd < A.length && even < A.length) {
                int temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
                odd += 2;
                even += 2;
            }
        }
        return A;
    }
}
