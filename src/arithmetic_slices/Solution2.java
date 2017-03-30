package arithmetic_slices;

/**
 * @author yejinbiao
 * @create 2017-03-30-17:38
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    public  int numberOfArithmeticSlices(int[] A) {
        int number = 0;
        int slices = 0;
       for (int i = 2; i < A.length; i++) {
           if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
               slices++;
               number += slices;
           }else {
               slices = 0;
           }
       }
       return number;
    }
}
