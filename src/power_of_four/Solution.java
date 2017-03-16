package power_of_four;

/**
 * @author yejinbiao
 * @create 2017-03-16-下午9:59
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(0));
    }

    public static boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        int higestBit = Integer.highestOneBit(num);
        if (higestBit != num) {
            return false;
        }
        int countZero = 0;
        while (higestBit != 0) {
            countZero += (higestBit & 1) == 0 ? 1 : 0;
            higestBit >>>= 1;
        }
        return countZero % 2 == 0;
    }

}
