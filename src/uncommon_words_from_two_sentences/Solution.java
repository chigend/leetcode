package uncommon_words_from_two_sentences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] uncommonWords = solution.uncommonFromSentences("", "");
        System.out.println(Arrays.toString(uncommonWords));
    }

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> wordsCount = new HashMap<>();
        String[] sentenceA = A.split(" ");
        String[] sentenceB = B.split(" ");
        countWords(sentenceA, wordsCount);
        countWords(sentenceB, wordsCount);
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public void countWords(String[] sentence, Map<String, Integer> wordsCount) {
        for (String word : sentence) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }
    }
}
