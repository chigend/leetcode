package encode_number;

public class Solution {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ":" + encode(i));
            ;
        }
    }

    public static String encode(int num) {
        int newValue = num + 1;
        int highestBit = Integer.highestOneBit(newValue);
        StringBuilder sb = new StringBuilder();

        int bit = 0;
        while (highestBit > 0) {
            highestBit >>= 1;
            bit++;
        }

        while (--bit > 0) {
            sb.append(((newValue >> (bit - 1)) & 1));
        }
        return sb.toString();

    }
}
