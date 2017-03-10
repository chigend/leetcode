package longest_word_in_dictionary_through_deleting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-10-下午9:18
 */

public class Solution {
    public static void main(String[] args) {
        String[] words = {
                "ba", "ab", "a", "b"};
        List<String> dictionary = Arrays.asList(words);
        String s = "bab";
        String longestWord = findLongestWord(s, dictionary);
        System.out.println(longestWord);

    }

    public static String findLongestWord(String s, List<String> d) {
        String result = "";
        /**
         * in case when there are more than one possible result, it should return result
         * according to the lexicographical order,so sort it
         */
        Collections.sort(d);
        for (String word : d) {
            /**
             *  a pointer in word,which means the current target char at which the value
             *  should be matched in s
             */
            int slow = 0;
            /**
             * a pointer in s ,at which the char that is currently compared with word[slow]
             */
            int fast = 0;
            while (true) {
                /**
                 * even if the word can be formed by deleting some character in s,it will
                 * be skipped because the length is not the longest,so just judge the length
                 */
                if (word.length() < result.length()) {
                    break;
                }
                /**
                 * try to find the position at which s[fast] = word[slow]
                 */
                while (fast < s.length() && s.charAt(fast) != word.charAt(slow)) {
                    fast++;
                }
                /**
                 * if fast reached s.length,and slow does not reach word's length,
                 * it means that there are some characters left in word not found in s.
                 */
                if (fast == s.length() && slow < word.length()) {
                    break;
                }
                /**
                 * if program reach here,one character match ,so move down the slow and fast
                 */
                slow++;
                fast++;
                /**
                 * if slow reach word's length, it means all character in word has found in
                 * s.
                 */
                if (slow == word.length()) {
                    /**
                     * if the current word's length is larger than result found previous,
                     * replace the result with current word,since the program require
                     * the longest word
                     */
                    if (word.length() > result.length()) {
                        result = word;
                    }
                    break;
                }

            }
        }
        return result;
    }
}
