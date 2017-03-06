package find_all_anagrams_in_a_string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yejinbiao
 * @create 2017-03-05-下午7:56
 */

public class Solution {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
//        String s = "abab";
//        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }

    public static  List<Integer> findAnagrams(String s, String p) {
        List <Integer> indices = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return indices;
        }
        int [] alphabet = new int[26];
        //先统计p的各字符的个数
        for (int index = 0; index < p.length(); index ++) alphabet[p.charAt(index) - 'a'] ++;
        int sLength = s.length();
        int pLength = p.length();
        for (int i = 0; i < sLength; i ++) {
            int start = i - pLength + 1;
            // 遍历s的char 如果当前的字符数 > p的长度 则把前一个字符+1
            if (i + 1 > pLength) {
                alphabet[s.charAt(start - 1) - 'a'] ++;
            }
            alphabet[s.charAt(i) - 'a']--;
            //如果当前的字符数大于等于p的长度，则可以判断当前subtring是否为anagram
            if ( i + 1 >= pLength && isAnagram(alphabet)) {
                indices.add(start);
            }
        }
        return indices;

    }
    public static boolean isAnagram(int [] alphabet) {
        for(int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
