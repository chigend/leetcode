package power_of_two;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午3:46
 */

public class Solution {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i+":"+isPowerOfTwo(i));
//        }
        int i = Integer.MAX_VALUE;
        System.out.print(-i);
    }

    public static boolean isPowerOfTwo(int n) {
        return n <= 0 ? false : Integer.highestOneBit(n) == n;
    }
}
