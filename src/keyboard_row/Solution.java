package keyboard_row;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-10-下午1:08
 */

public class Solution {
    public static void main(String[] args) {
        String [] words = new String[] {"ac"};
        words = findWords(words);
        System.out.println(Arrays.toString(words));
    }

    public static String[] findWords(String[] words) {
        //record line every alphabet belong to
        int [] alphanetRows = new int [] {2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> result = new ArrayList<>();
        out:for (int i = 0;i < words.length;i ++) {
            String original = words[i];
            String word = original.toLowerCase();
            if (word.length() == 0) {
                result.add(original);
                continue;
            }
            //record the line where the first alphabet in word belongs to
            int line = alphanetRows[word.charAt(0)-'a'];
            for (int j = 1; j < word.length();j ++) {
                //if the left part is not the same ,just skip the word
                if (alphanetRows[word.charAt(j) - 'a'] != line) {
                    continue out;
                }
            }
            result.add(original);
        }
        return result.toArray(new String[]{});
    }

}
