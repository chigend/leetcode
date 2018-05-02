package unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        int unique = uniqueMorseRepresentations(words);
        System.out.println(unique);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> unique = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            char[] chs = word.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                sb.append(morseCodes[c - 'a']);
            }
            unique.add(sb.toString());
        }
        return unique.size();
    }
}
