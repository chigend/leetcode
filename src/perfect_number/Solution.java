package perfect_number;

/**
 * @author yejinbiao
 * @create 2017-03-26-9:32
 */

public class Solution {
    public static void main(String[] args) {
        boolean is = checkPerfectNumber(28);
        System.out.println(is);
    }

    public static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i != num / i) sum += num / i;
                sum += i;
            }
        }
        //since every number have divisor 1 except 1 itself
        return num != 1 && sum + 1 == num;
    }
}
