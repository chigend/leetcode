package hamming_distance;

/**
 * @author yejinbiao
 * @create 2017-03-10-上午9:29
 */

public class Solution {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        int distance = hammingDistance2(x, y);
        System.out.println(distance);
    }

    public static int hammingDistance(int x, int y) {
        int result = x ^ y;
        String s = Integer.toBinaryString(result);
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '1') {
                count ++;
            }
        }
        return count;
    }
        // bit operation is more effective
    public static int hammingDistance2(int x, int y) {
        int result = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i ++) {
            count += (result >> i) & 1;
        }
        return count;
    }

}
