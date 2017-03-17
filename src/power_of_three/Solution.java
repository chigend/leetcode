package power_of_three;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午3:04
 */

public class Solution {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + ":" + isPowerOfThree(i));
//        }
    }

    public static boolean isPowerOfThree(int n) {
        double power = Math.log1p((double) n) / Math.log(3);
        return Math.pow(3,(int)power) == n;
    }
}
