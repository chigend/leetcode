package valid_anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-05-下午12:52
 */

public class Solution {
    public static void main(String[] args) {
        String s = "hello";
        String t = "oellh";
        boolean flag = isAnagram(s, t);
        System.out.println(flag);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> characterCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterCount.containsKey(c)) {
                int count = characterCount.get(c);
                characterCount.put(c, count + 1);
            } else {
                characterCount.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = 0;
            if (characterCount.containsKey(c)) {
                count = characterCount.get(c);
            }
            if (count == 1) {
                characterCount.remove(c);
            }else {
                characterCount.put(c, count - 1);
            }
        }
        return characterCount.size() == 0;
    }
    //a more effective solution for alphabets,but can't be used when input is unicode characters
    public boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
