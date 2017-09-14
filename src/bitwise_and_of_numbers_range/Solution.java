package bitwise_and_of_numbers_range;

public class Solution {
    public static void main(String[] args) {
        int and = rangeBitwiseAnd(600000000
                ,                Integer.MAX_VALUE-2);
        System.out.println(and);
//        System.out.println(Integer.toBinaryString(600000000));
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE-2));
        //0100011110000110100011000000000
        //1111111111111111111111111111101
//        100
//        111
    }

    /**
     * the idea is to find the most significant bits that m and n both holds
     * e.g  4-7     0100 0111 the most significant bits holds is 0100 so the result is 4
     *      12-15   1101 1111 the most significant bits holds is 1100 so the result is 12
     *              1010 1011 the most significant bits both holds is 1010 so the result is 10
     *      600000000-2147483645 0100011110000110100011000000000
     *                           1111111111111111111111111111101
     *                         there is no most significant bits that m and n both holds
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m, int n) {
        int num = Integer.MIN_VALUE;
        int result = 0;
        while ((num >>>= 1) != 0) {
            if ((m & num) == 0 && (n & num) == 0) {
                continue;
            }else if ((m & num) == num && (n & num) == num) {
                result |= num;
                m &= (num - 1);
                n &= (num - 1);
            } else{
                break;
            }
        }
        return result;
    }

}
