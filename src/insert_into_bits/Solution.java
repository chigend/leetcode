package insert_into_bits;

public class Solution {

    public static void main(String[] args) {
        int N = Integer.parseInt("1111100001001100100111000001101", 2);
        int M = Integer.parseInt("101", 2);
        int i = insertBits(645256491,
                151292,
                0,
                22);
        System.out.println(i);

    }

    public static int insertBits(int N, int M, int i, int j) {
        int mask = ((1 << (j - i + 1)) - 1) << i;
        return (N & ~mask) | M << i;
    }
}
