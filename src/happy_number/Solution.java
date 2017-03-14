package happy_number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yejinbiao
 * @create 2017-03-13-下午2:46
 */

public class Solution {
    public static void main(String[] args) {
        boolean isHappy = isHappy(24);
        System.out.println(isHappy);
    }

    public static boolean isHappy(int n) {
        Set<Integer> table = new HashSet<>();
        int sum = n;
        while (table.add(sum)) {
            int number = sum;
            sum = 0;
            while (number != 0) {
                int digit = number % 10;
                number = number / 10;
                sum += digit * digit;
            }
            if (sum == 1) {
                return true;
            }
        }
        return false;
    }
}
