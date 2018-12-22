package di_string_match;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] permutation = solution.diStringMatch("I");
        System.out.println(Arrays.toString(permutation));
    }

    public int[] diStringMatch(String S) {
        char[] chs = S.toCharArray();
        int start = 0;
        int end = chs.length;
        int[] result = new int[end + 1];
        for (int i = 0; i < chs.length; i++) {
            result[i] = chs[i] == 'I' ? start++ : end--;
        }
        result[chs.length] = end;
        return result;
    }
}
