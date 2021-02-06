package decode_xored_array;

import tool.ArrayPrinter;
import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] transform = ArrayTestCaseTransformer.transform("[6,2,7,3]");
        int[] decode = decode(transform, 4);
        ArrayPrinter.print(decode);
    }

    public static int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];
        res[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            res[i + 1] = encoded[i] ^ res[i];
        }
        return res;
    }
}
