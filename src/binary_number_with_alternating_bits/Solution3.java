package binary_number_with_alternating_bits;

public class Solution3 {
    public static void main(String[] args) {

    }
    public boolean hasAlternatingBits(int n) {
        int last = n & 1;
        n >>= 1;
        while (n != 0) {
            int now = n & 1;
            if (now == last) {
                return false;
            }
            last = now;
            n >>= 1;
        }
        return true;
    }
}
