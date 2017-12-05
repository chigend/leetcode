package arithmetic_slices;

/**
 * @author yejinbiao
 * @create 2017-03-30-17:07
 */

public class Solution {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,6,7,8,9};
        int slices = numberOfArithmeticSlices(nums);
        System.out.print(slices);

    }
    public static int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) return 0;
        int number = 0;
        int difference = A[1] - A[0];
        int start = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] != difference) {
                difference = A[i] - A[i - 1];
                number += calculateSlices(i - start);
                start = i -1;
            }
        }
        number += calculateSlices(A.length - start);
        return number;
    }
    private static int calculateSlices(int length) {
        if (length < 3) return 0;
        return (length - 2) * (length - 1) / 2;
    }
}
