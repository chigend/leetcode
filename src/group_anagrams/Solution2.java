package group_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-27-上午11:07
 */

public class Solution2 {
    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> table = new HashMap<>();

        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (table.containsKey(s)) {
                table.get(s).add(str);
            } else {
                List<String> group = new ArrayList();
                group.add(str);
                table.put(s, group);
            }
        }
        for (List<String> g : table.values()) res.add(g);
        return res;
    }
}
