package sort_array_by_parity_ii;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.sortArrayByParityII(new int[]{4,2,5,7});
        System.out.println(Arrays.toString(res));
    }

    /**
     * O(n) space complexity solution
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        int even = 0;
        int odd = 0;
        int[] res = new int[A.length];
        int index = 0;
        while (even < len && odd < len) {
            while (even < len && (A[even] & 1) == 1) {
                even++;
            }
            while (odd < len && (A[odd] & 1) == 0) {
                odd++;
            }
            res[index++] = A[even++];
            res[index++] = A[odd++];
        }
        return res;
    }
}
