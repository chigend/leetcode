package _2_keys_keyboard;

public class Solution {
    public static void main(String[] args) {
        int count = minSteps(12);
        System.out.println(count);
    }

    public static int minSteps(int n) {
        if ((n & (n - 1)) == 0) {
            return 2 * count(n);
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return i + minSteps(n / i);
            }
        }
        return n;
    }

    private static int count(int n) {
        int count = 0;
        while ((n >>=1) != 0) {
            count++;
        }
        return count;
    }
}
