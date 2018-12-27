package reordered_power_of_2;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {

    }

    public boolean reorderedPowerOf2(int N) {
        long count = counter(N);
        for (int i = 0; i < 31; i++) {
            if (count == counter(1 << i)) return true;
        }
        return false;
    }

    private long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10 ) res += (int)Math.pow(10, N % 10);
        return res;
    }
}
