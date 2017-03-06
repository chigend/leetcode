package find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

/**
 *  优化第一个Solution，第一个Solution判断是否为anagram的方法是遍历hashtable（int[]alphabet）,
 *  每一个字符的count都为0，则说明当前substring为anagram,其实只要用一个统计字符数量的count就可以
 *  判断
 */

public class Solution3 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
//        String s = "abab";
//        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List <Integer> indices = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return indices;
        }
        int [] alphabet = new int[26];
        //先统计p的各字符的个数
        for (int index = 0; index < p.length(); index ++) alphabet[p.charAt(index) - 'a'] ++;
        int sLength = s.length();
        int pLength = p.length();
        /**
         * charCount  the char count which is to be consumed
         */
        int charCount = pLength;
        int start = 0;
        int end = 0;
        while(end < sLength) {
            /**
             * when the window size grow up to p.length(), the hashtable should kick out the previous
             * char as the end variable move right.so the count of the previous char should add 1,
             * if the count >= 0, the charCount increase
             */
            if (end - start == pLength && alphabet[s.charAt(start++) - 'a']++ >= 0) {
                charCount ++;
            }
            /**
             if the count of the current char <= 0 it means the original char has consumed out（消费完）,
             so the charCount should not decrease
             *
             */
            if (alphabet[s.charAt(end++) - 'a']-- > 0) {
                charCount --;
            }
            /**
             * if the charCount = 0, it means the chars is completely same as original chars
             */
            if (charCount == 0) {
                indices.add(start);
            }
        }
        return indices;

    }

}
