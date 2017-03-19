package sort_characters_by_frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yejinbiao
 * @create 2017-03-18-下午9:23
 */

public class Solution {
    public static void main(String[] args) {
        String s = frequencySort("cccaaaa");
        System.out.print(s);
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> table = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        for (char c : chars) {
            int count = table.getOrDefault(c, 0);
            count++;
            max = Math.max(count, max);
            table.put(c, count);
        }
        String[] array = new String[max + 1];
        for (Character c : table.keySet()) {
            int count = table.get(c);
            String str = array[count];
            array[count] = str == null ? "" + c : str + c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = array.length - 1; i >= 0; i--) {
            String str = array[i];
            if (str != null) {
                for (char c : str.toCharArray()) {
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
