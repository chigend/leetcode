package counting_bits;

import java.util.Arrays;

/**
 * @author yejinbiao
 * @create 2017-03-14-上午11:19
 */

public class Solution {
    public static void main(String[] args) {
        int [] bits = countBits(23);
        System.out.print(Arrays.toString(bits));
    }
    public static int[] countBits(int num) {

       int [] bits = new int[num + 1];
       for (int i = 1; i <= num; i++){
           //找到和当前这个数最相近的2的幂次数
           int closestPowerOftwo = Integer.highestOneBit(i);
           //如果这个数是2的幂次数，则bit为1
           if (closestPowerOftwo == i) {
               bits[i] = 1;
           }else {
               //其他数的bit个数都为最相近的2的幂次数(即为1)加上剩余的数
               //比如23，23 = 1（16）+bits[7] = 1+1(4)+bits[3]=2+1(2)+bit[1]=4
               bits[i] = 1 + bits[i - closestPowerOftwo];
           }
       }
       return bits;
    }
}
