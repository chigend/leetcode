package sum_of_square_numbers;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<Long, Boolean> canSquare = new HashMap<>();
    public static void main(String[] args) {
        boolean can = judgeSquareSum(8);
        System.out.println(can);
    }

    public static boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            int sumSquare = a * a + b * b;
            if (sumSquare > c) {
                b--;
            }else if (sumSquare < c) {
                a++;
            }else {
                return true;
            }
        }
        return false;
    }
}
