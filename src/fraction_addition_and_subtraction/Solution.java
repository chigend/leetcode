package fraction_addition_and_subtraction;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String res = fractionAddition("1/3-1/2");
        System.out.println(res);
    }


    public static String fractionAddition(String expression) {
        char[] chs = expression.toCharArray();
        int start = 0;
        long sumNumberator = 0;
        long sumDenominator = 3628800;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == '+' || chs[i] == '-') {
                String fraction = expression.substring(start, i);
                int slash = fraction.indexOf("/");
                int numberator = Integer.parseInt(fraction.substring(0, slash));
                int denominator = Integer.parseInt(fraction.substring(slash + 1));
                sumNumberator += (long) numberator * (sumDenominator / denominator);
                start = i;
            }
        }
        String fraction = expression.substring(start);
        int slash = fraction.indexOf("/");
        int numerator = Integer.parseInt(fraction.substring(0, slash));
        int denominator = Integer.parseInt(fraction.substring(slash + 1));
        sumNumberator += (long) numerator * (sumDenominator / denominator);
        int gcd = 0;
        if (sumNumberator < 0) {
            gcd = gcd((int) -sumNumberator, (int) sumDenominator);
        } else {
            gcd = gcd((int) sumNumberator, (int) sumDenominator);

        }
        return sumNumberator / gcd + "/" + sumDenominator / gcd;
    }

    //get greatest common divisor of numerator and denominator
    private static int gcd(int a, int b) {
        int mod = b;
        while (mod != 0) {
            int temp = b;
            mod = a % b;
            a = temp;
            b = mod;
        }
        return a;
    }
}
