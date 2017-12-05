package sentence_similarity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Solution {
    public static void main(String[] args) {
        String[] words1 = new String[]{"great","fine", "fine"};
        String[] words2 = new String[]{"fine", "great", "great"};
        String[][] pairs = {{"great","fine"},{"acting","drama"},{"skills","talent"},{"fine","good"}};
        boolean similar = areSentencesSimilar(words1,words2,pairs);
        System.out.println(similar);
    }

    public static boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            map.putIfAbsent(pairs[i][0], new HashSet());
            map.get(pairs[i][0]).add(pairs[i][1]);
            map.putIfAbsent(pairs[i][1], new HashSet());
            map.get(pairs[i][1]).add(pairs[i][0]);
        }
        for (int i = 0; i < words1.length; i++) {
            if ((words1[i].equals(words2[i]))){
                 continue;
            }
            if (!map.getOrDefault(words1[i],new HashSet<>()).contains(words2[i])) {
                return false;
            }
            if (!map.getOrDefault(words2[i],new HashSet<>()).contains(words1[i])) {
                return false;
            }
        }
        return true;
    }

}
