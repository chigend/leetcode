package minimum_flips_to_make_a_or_b_equal_to_c;

public class Solution {

    public static void main(String[] args) {

    }

    public int minFlips(int a, int b, int c) {
        //获取到哪几位不一样
        int diff = (a | b) ^ c;

        /**
         * /以下表达式只有这几种情况, 为简化,  只描述某一位的情况,
         *  a=1  b=1 c=0   这时翻转数+2(a,b都要翻转)     a^b^c=0
         *  a=1  b=0  c=0  这时翻转数+1(a翻转)    a^b^c =1
         *  a=0  b=1  c=0  这时翻转数+1(b翻转)    a^b^c = 1
         *  a=0 b=0  c=1  这时翻转数+1(a或b翻转)     a^b^c=1
         *
         *  其他组合情况都是不符合条件, 因为其他情况下  diff变量(也就是 (a|b) ^c的对应位为0, 表示不用翻转,无效),例如:
         *
         *  a=0, b=0 c=0  那么 (a|b) == c  不用翻转
         *  a=1  b=1  c=1  那么 (a|b) == c  不用翻转
         *  a=1, b=0, c=1,   那么 (a|b) == c  不用翻转
         *  a=0 b=1, c=1  那么 (a|b) == c  不用翻转
         *
         *  所以综上情况,    a^b^c有效位为1, 则翻转数+1, a^b^c有效位为0, 则翻转数+2, 有效位根据 diff变量(也就是 (a|b) ^c)来
         */

        int xor = a ^ b ^ c;

        int count = 0;
        while (diff != 0) {
            //取到最低位为1,其余位置0的数
            int mask = diff & -diff;
            if ((xor & mask) > 0) {
                count += 1;
            } else {
                count += 2;
            }
            diff -= mask;
        }
        return count;
    }
}
