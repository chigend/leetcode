package group_anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-27-上午10:26
 */

public class Solution {
    public static void main(String[] args) {
        String [] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(groupAnagrams(s));
    }

    public static   List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char [] chars = str.toCharArray();
            int [] alphabet = new int[26];
            for (int i = 0;i < str.length();i ++) {
                alphabet[chars[i] - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0;i < alphabet.length;i ++) {
                if (alphabet[i] != 0) {
                    sb.append((char)('a' + i)).append(alphabet[i]);
                }
            }
            String sign = sb.toString();
            if (groups.containsKey(sign)) {
                groups.get(sign).add(str);
            }else {
                List<String> words = new ArrayList<>();
                words.add(str);
                groups.put(sign, words);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) result.add(group);
        return result;
    }
}
