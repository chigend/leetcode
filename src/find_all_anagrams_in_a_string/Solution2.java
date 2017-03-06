package find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-05-下午1:19
 */

public class Solution2 {
    static int [] alphabet = new int[26];
    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";
        String s = "abab";
        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return indices;
        }
        for (int i = 0; i < p.length(); i++) alphabet[p.charAt(i) - 'a']++;
        int pLength = p.length();
        int sLength = s.length();
        /**
         * 定义一个标记来表示前一个subtring是否是anagram，如果是的话，则只需要判断下一个subtring的
         * 的最后一个字符是否与第一个字符的前一个字符相等，而不需要对整个subtring进行判断
         */
        boolean preMatched = false;
        for (int i = 0; i <= sLength - pLength; i++) {
            int end = i + pLength;
            if (preMatched) {
                if (s.charAt(end - 1) == s.charAt(i - 1)) {
                    indices.add(i);
                    preMatched = true;
                    continue;
                }
            }
            String substring = s.substring(i, end);
            if (isAnagram(substring)) {
                indices.add(i);
                preMatched = true;
            }else {
                preMatched = false;
            }
        }
        return indices;
    }

    public static boolean isAnagram(String t) {
        int [] array = new int[26];
        System.arraycopy(alphabet, 0 ,array, 0 , 26);
        for (int i = 0; i < t.length(); i++) array[t.charAt(i) - 'a']--;
        for (int i : array) if (i != 0) return false;
        return true;
    }

}
