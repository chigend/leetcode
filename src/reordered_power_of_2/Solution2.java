package reordered_power_of_2;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().reorderedPowerOf2(821));
    }

    public boolean reorderedPowerOf2(int N) {
        int[] count = countNumber(N);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(count, countNumber(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private int[] countNumber(int n) {
        int[] res = new int[10];
        while (n != 0) {
            res[n % 10]++;
            n /= 10;
        }
        return res;
    }
}
