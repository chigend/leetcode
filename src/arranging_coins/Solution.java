package arranging_coins;

/**
 * @author yejinbiao
 * @create 2017-03-06-下午2:50
 */

public class Solution {
    public static void main(String [] args) {
        System.out.println(arrangeCoins(1804289383));
    }

    public static int arrangeCoins(int n) {
        if (n == 0) return 0;
        long start = 1;
        long end = n;
        long num = n;
        while (start <= end) {
            long medium = (start + end) >> 1;
            long sum = (medium + 1) * medium / 2;
            if (num > sum) {
                start = medium + 1;
            }else if (num < sum) {
                end = medium - 1;
            }else {
                return (int)medium;
            }
        }
        return (int)(start - 1);
    }


}
