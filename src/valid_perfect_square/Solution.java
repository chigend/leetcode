package valid_perfect_square;

/**
 * @author yejinbiao
 * @create 2017-03-15-下午6:05
 */

public class Solution {
    public static void main(String[] args) {
        boolean isPerfectSquare = isPerfectSquare(Integer.MAX_VALUE);
        System.out.print(isPerfectSquare);
    }


    public static boolean isPerfectSquare(int num) {
        long numLong = (long) num;
        long low = 0;
        long high = numLong;
        while (low <= high) {
            long medium = (low + high) >> 1;
            long power = medium * medium;
            if (power < numLong) {
                low = medium + 1;
            }else if (power > numLong) {
                high = medium - 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
