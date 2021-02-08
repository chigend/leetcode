package maximum_product_of_word_lengths;

import java.lang.reflect.Array;
import java.util.Arrays;

import tool.ArrayTestCaseTransformer;

public class Solution {

    public static void main(String[] args) {
        int i = maxProduct(ArrayTestCaseTransformer.transformString("[\"eae\",\"ea\",\"aaf\",\"bda\",\"fcf\",\"dc\",\"ac\",\"ce\",\"cefde\",\"dabae\"]"));
        System.out.println(i);
    }

    public static int maxProduct(String[] words) {

        int[] res = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chs = word.toCharArray();
            int value = 0;
            for (char ch : chs) {
                value |= 1 << (ch - 'a');
            }
            res[i] = value;
        }

        int max = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = i + 1; j < res.length; j++) {
                if ((res[i] & res[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

}
