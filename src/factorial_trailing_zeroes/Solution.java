package factorial_trailing_zeroes;

/**
 * @author yejinbiao
 * @create 2017-03-26-19:47
 */

public class Solution {
    public static void main(String[] args) {
        int n = trailingZeroes(25);
        System.out.println(n);
    }

    /**
     * count the number of zero is to count the number 5 that appear because 0 come from 2 * 5, since there must be more 2
     * than 5,the number of trailing zero depends on the number 5
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            /**
             * every time we divide the n by n,and count the number 5,and next we count n/5,and all......
             * example   50   we divide 50 by 5 and get 10, it means there are ten 5s at least, and
             */
            n /= 5;
            count += n;
        }
        return count;
    }
}
