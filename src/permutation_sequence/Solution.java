package permutation_sequence;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午3:54
 */

public class Solution {
    public static void main(String[] args) {
        String permutation = getPermutation(4, 23);
        System.out.print(permutation);
    }

    public static String getPermutation(int n, int k) {
        int[] factorials = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
        boolean[] picked = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        k--;
        while (--n > 0) {
            /**
             * 首先需要算出n-1的阶乘，也就是除去当前位，剩余的有多少种排列组合，
             *
             */
            int ways = factorials[n];
            int quotient = k / ways;
            int mod = k % ways;
            /**
             * 用k去除，可得出这个位是的数是第几个
             * 比如n=4，3的阶乘是6，k=5，
             * 得出当前位的数是第0个,然后要从剩余的未被选的数中选出第1个
             */
            int count = quotient;
            for (int i = 1; i < picked.length; i++) {
                if (picked[i]) continue;
                if (count == 0) {
                    sb.append(i);
                    picked[i] = true;
                    break;
                }
                count --;

            }
            /**
             * 计算出除去当前位后，要求的数的相对位置，比如n=4，k=3
             * 求出第一个数是1后，那么后面的数都落在1xxx中，此时的k应该为
             * 要求的数在1xxx中的相对位置,相对位置的值即为上一步的模值
             */
            k = mod;
        }
        for (int i = 1; i < picked.length; i++) {
            if (!picked[i]) {
                sb.append(i);
                break;
            }
        }
        return sb.toString();
    }

}
