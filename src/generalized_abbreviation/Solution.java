package generalized_abbreviation;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> word = generateAbbreviations("word");
        System.out.println(word);
    }

    public static List<String> generateAbbreviations(String word) {
        int length = word.length();

        List<String> list = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (int i = 0; i < (1 << length); i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < length; j++) {
                if ((i >> (length - j - 1) & 1) == 1) {
                    count++;
                } else {
                    if (count > 0) {
                        sb.append(count);
                        count = 0;
                    }

                    sb.append(chs[j]);
                }
            }
            if (count > 0) {
                sb.append(count);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
