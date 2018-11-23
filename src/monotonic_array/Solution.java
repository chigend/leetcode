package monotonic_array;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1,3,4,5}));
    }

    public static boolean isMonotonic(int[] A) {
       Boolean increase = null;
        for (int i = 1; i < A.length; i++) {
            int sub = A[i] - A[i - 1];
            if (increase == null && sub != 0) {
                increase = sub > 0;
            }else if (sub != 0 && sub > 0 != increase){
                return false;
            }
        }
        return true;
    }
}
