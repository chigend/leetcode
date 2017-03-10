package number_complement;

/**
 * @author yejinbiao
 * @create 2017-03-10-上午9:51
 */

public class Solution {
    public static void main(String []args) {
//       int complement =  findComplement(5);
//       System.out.print(complement);
        Integer higestOneBit = (Integer.highestOneBit(5) << 1) - 1;
        System.out.print(higestOneBit);
    }

    public static int findComplement(int num) {
        int length = Integer.toBinaryString(num).length();
        int result = 0;
        for (int i = 0; i < length; i ++) {
            /**
             * num >> i   get the last number only
             * (num >> i) ^ 1   reverse the last number   if the last number is 1,change it the 0,if the last number is 0,change it to 1;
             */
            int complement = ((num >> i) & 1) ^ 1;
            result += complement << i;
        }
        return result;
    }

    public static int findComplement2(int num) {
        /**
         *
         * 先获取num二进制形式的去掉leading-zero后长度的掩码，Integer.highestOneBit()可以获取num的最高位为1，其余清0的数
         * 比如： 5  二进制去掉前面的0后是 101，Integer.highestOneBit(5) = 100 = 4
         * 那么获取3个长度的掩码 就是  (4 << 1) - 1   4 << 1 = 1000    1000 - 1 = 111
         * 最后将这个掩码与原来的数的反码进行与运算
         */
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~ num;
        return num & mask;
    }
}
