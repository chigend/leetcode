package minimum_factorization;

/**
 * @author yejinbiao
 * @create 2017-06-20-19:04
 */

public class Solution {
    public static void main(String[] args) {

    }
    public static int smallestFactorization(int a) {
        if (a == 1) return a;
        StringBuilder sb = new StringBuilder();
        int divisor = 9;
        while (a != 0 && divisor > 1) {
            if (a % divisor == 0) {
                a /= divisor;
                sb.insert(0,divisor);
                continue;
            }
            divisor--;
        }
        //if a can not be divided to 1,it means there is no result
        if (a != 1) return 0;
        try {
            return Integer.parseInt(sb.toString());
        }catch (NumberFormatException e) {
            //if catch exception,it means the result can not fit integer range
            return 0;
        }
    }
}
