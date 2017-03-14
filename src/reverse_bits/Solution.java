package reverse_bits;

/**
 * @author yejinbiao
 * @create 2017-03-14-上午10:20
 */

public class Solution {
    public static void main(String[] args) {
        int result = reverseBits(2);
        System.out.println(result);
    }
    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += (n >> i) & 1;
        }
        return result;
    }

}
