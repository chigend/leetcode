package binary_number_with_alternating_bits;

public class Solution2 {
    public static void main(String[] args) {

    }

    public static boolean hasAlternatingBits(int n) {
        //if n have alternating bits, then the xor result of n and n >> 1 n right shift by one bit
        // will be all 1 from some bit,like 00011111 00000111 00111111 11111111
        int xor = (n >> 1) ^ n;
        //so now just validate if the xor result appears to be a number that there are all 1 from some
        //bit in it's binary representation
        return (xor & (xor + 1)) == 0;
    }
}
