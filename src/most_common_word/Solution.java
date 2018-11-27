package most_common_word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String mostCommon = solution.mostCommonWord("bob", new String[]{"hit"});
        System.out.println(mostCommon);
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        //由于该算法依赖后一个字符来决定前一个单词是否结束, 所以当最后以单词结尾的时候需要结束符
        paragraph += '.';
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordCount = new HashMap<>();
        char[] chs = paragraph.toCharArray();
        int max = 0;
        int start = 0;
        for (int i = 0; i < chs.length; i++) {
            if (!Character.isLetter(chs[i])) {
                if (i - start > 0) {
                    String lowercase = new String(chs, start, i - start).toLowerCase();
                    if (!bannedWords.contains(lowercase)) {
                        int count = wordCount.getOrDefault(lowercase, 0) + 1;
                        max = Math.max(max, count);
                        wordCount.put(lowercase, count);
                    }
                }
                start = i + 1;
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        return null;
    }

}
