package counting_bits;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-14-上午11:44
 */

public class Solution2 {
    public static void main(String[] args) {
        int [] bits = countBits(4);
        System.out.println(Arrays.toString(bits));
    }
    public static int[] countBits(int num) {
        int [] bits = new int[num + 1];
        for (int i= 0; i <= num; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }
}
