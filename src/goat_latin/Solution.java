package goat_latin;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {
        String goatLatins = toGoatLatin("a v");
        System.out.println(goatLatins);
//        System.out.println(goatLatins.equals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
    }

    public static String toGoatLatin(String S) {
        String[] words = S.split(" ");
        List<String> goatLatins = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            if (!startWithVowel(word)) {
                char[] chs = word.toCharArray();
                for (int j = 1; j < chs.length; j++) {
                    sb.append(chs[j]);
                }
                sb.append(chs[0]);
            }else {
                sb.append(word);
            }
            sb.append("ma");
            appendA(i + 1, sb);
            goatLatins.add(sb.toString());
        }
        return String.join(" ", goatLatins);
    }

    static boolean  startWithVowel(String word) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        char first = word.charAt(0);
        for (char vowel : vowels) {
            if (vowel == Character.toLowerCase(first)) {
                return true;
            }
        }
        return false;
    }

    static void appendA(int index, StringBuilder word) {
        for (int i = 0; i < index; i++) {
            word.append('a');
        }
    }
}
