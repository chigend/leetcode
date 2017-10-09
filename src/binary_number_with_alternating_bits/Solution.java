package binary_number_with_alternating_bits;

public class Solution {
    public static void main(String[] args) {
       boolean is =  hasAlternatingBits(1);
       System.out.println(is);
    }

    public static boolean hasAlternatingBits(int n) {
        int paddingOne = paddingOne(n);
        int mask = paddingOne & 0x55555555;
        int xor = mask ^ n;
        return xor == paddingOne || xor == 0;
    }

    /**
     * get the number that there are all 1 from the highest bit of the binary representation of n.
     * e.g 8 (binary representation 1000 ) so it return 15(1111),5(101) return 7(111)
     * @param n
     * @return
     */
    private static int paddingOne(int n) {
        n |= (n >> 1);
        n |= (n >> 2);
        n |= (n >> 4);
        n |= (n >> 8);
        n |= (n >> 16);
        return n;
    }
}
