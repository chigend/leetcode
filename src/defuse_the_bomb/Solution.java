package defuse_the_bomb;

import tool.ArrayPrinter;
import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int[] transform = ArrayTestCaseTransformer.transform("[2,4,9,3]");
        int[] decrypt = decrypt(transform, -2);
        ArrayPrinter.print(decrypt);
    }

    public static int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            return res;
        }
        if (k < 0) {
            k = -k;
            for (int i = code.length - 1; i >= 0; i--) {
                for (int j = 1; j <= k; j++) {
                    res[i] += code[(i - j + code.length) % code.length];
                }
            }

        } else if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                for (int j = 1; j <= k; j++) {
                    res[i] += code[(i + j) % code.length];
                }
            }
        }
        return res;

    }
}
