package longest_word_in_dictionary_through_deleting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-10-下午10:06
 */

/**
 * a optimize solution ,since it should return the longest word,so just sort the words,
 * and search from the longest word.
 */
public class Solution2 {
    public static void main(String[] args) {
        String[] words = {
                "ba", "ab", "a", "b"};
        List<String> d = Arrays.asList(words);
        String s = "bab";
        System.out.println(findLongestWord(s,d));

    }

    public static String findLongestWord(String s, List<String> d) {
        String result = "";

        Collections.sort(d, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b) );
        out:for (String word : d) {
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
                    result = word;
                    break out;
                }

            }
        }
        return result;
    }
}
