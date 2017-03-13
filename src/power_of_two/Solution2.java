package power_of_two;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午4:01
 */

public class Solution2 {
    public static void main(String[] args) {

    }

    /**
     * since if n is the power of two, it's 2 representation is 1 10 100 1000 10000 100000
     * so just apply and operator to n and n - 1
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
