package number_of_lines_to_write_string;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.numberOfLines(new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "bbbcccdddaaa");
        System.out.println(Arrays.toString(res));
    }

    public int[] numberOfLines(int[] widths, String S) {
        char[] chs = S.toCharArray();
        int i = 0;
        int character = 0;
        int lines = 1;
        while (i < S.length()) {
            int width = widths[chs[i] - 'a'];
            if (character + width > 100) {
                lines ++;
                character = 0;
            }else {
                character += width;
                i++;
            }
        }
        return new int[]{lines, character};
    }
}
