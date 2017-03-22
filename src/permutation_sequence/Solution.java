package permutation_sequence;

/**
 * @author yejinbiao
 * @create 2017-03-22-下午3:54
 */

public class Solution {
    public static void main(String[] args) {
        String permutation = getPermutation(4,23);
        System.out.print(permutation);
    }

    public static String getPermutation(int n, int k) {
        int [] factorials = {0,1,2,6,24,120,720,5040,40320,362880,3628800};
        boolean [] picked = new boolean[n + 1];
        int quotient = 0;
        int mod = 0;
        StringBuilder sb = new StringBuilder();
        while (--n > 0) {
            /**
             * 首先需要算出n-1的阶乘，也就是除去当前位，剩余的有多少种排列组合，
             *
             */
            int ways = factorials[n];
            quotient = k / ways;
            mod = k % ways;
            /**
             * 用k去除，可得出这个位是的数是第几个，这里得分能否整除，如果能整除，
             * 位数（count）就是第quotient个，如果不能整除就是quotient + 1，总之
             * 就是计算出当前位所落在的位置。
             * 比如n=4，3的阶乘是6，k=5，
             * 得出当前位的数是第1个,然后要从剩余的未被选的数中选出第1个
             */
            int count = mod == 0 ? quotient  : quotient + 1;
            for (int i = 1; i < picked.length; i++) {
                if (picked[i]) continue;
                count--;
                if (count == 0) {
                    sb.append(i);
                    picked[i] = true;
                }
            }
            /**
             * 计算出除去当前位后，要求的数的相对位置，比如n=4，k=3
             * 求出第一个数是1后，那么后面的数都落在1xxx中，此时的k应该为
             * 要求的数在1xxx中的相对位置,此时也要分能整除和不能整除，
             * 如果能整除，那么相对位置就是第ways个，ways为当前层的排列组合总数
             * 如果不能整除，那么相对位置就是模值
             */
            k = mod == 0 ? ways : mod;
        }
        for (int i = 1; i < picked.length; i++) {
            if(!picked[i]) {
                sb.append(i);
                break;
            }
        }
        return sb.toString();
    }

}
