package top_k_frequent_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        List<String> result = topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2);
        System.out.println(result);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> table = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int count = table.getOrDefault(word, 0);
            count++;
            table.put(word, count);
        }
        PriorityQueue<Map.Entry<String,Integer>> queue = new PriorityQueue<>(
                (a,b) -> {
                    int c = b.getValue() - a.getValue();
                    return c == 0 ? a.getKey().compareTo(b.getKey()) : c;
                }
        );
        queue.addAll(table.entrySet());
        while (result.size() < k) {
            result.add(queue.poll().getKey());
        }
        return result;
    }
}
