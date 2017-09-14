package bitwise_and_of_numbers_range;

public class Solution2 {
    public static void main(String[] args) {

    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int move = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            move++;
        }
        return m << move;
    }
}
