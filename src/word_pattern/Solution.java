package word_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-14-上午9:19
 */

public class Solution {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        boolean matches = wordPattern(pattern,str);
        System.out.println(matches);
    }

    public static boolean wordPattern(String pattern, String str) {
        String [] patterns = new String[256];
        Map<String,Character> table = new HashMap<>();
        String [] words = str.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (patterns[c] == null ) {
                if (table.get(word) != null) {
                    return false;
                }else {
                    table.put(word, c);
                    patterns[c] = word;
                }
            }else if (!patterns[c].equals(words[i])) {
                return false;
            }
        }
        return true;
    }
}
