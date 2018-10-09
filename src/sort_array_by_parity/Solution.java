package sort_array_by_parity;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{1,2,3,4,5,6,7,8,9,10})));
    }

    public static int[] sortArrayByParity(int[] A) {
        int evenIndex = 0;
        int oddIndex = A.length - 1;
        while (evenIndex < oddIndex) {
            while (evenIndex < A.length && (A[evenIndex] & 1) == 0){
                evenIndex++;
            }
            while (oddIndex > 0 && (A[oddIndex] & 1) == 1) {
                oddIndex--;
            }
            if (evenIndex < oddIndex) {
                A[evenIndex] = A[evenIndex] ^ A[oddIndex];
                A[oddIndex] = A[oddIndex] ^ A[evenIndex];
                A[evenIndex] = A[evenIndex] ^ A[oddIndex];
            }
        }
        return A;
    }
}
